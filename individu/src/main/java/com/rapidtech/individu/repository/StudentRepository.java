package com.rapidtech.individu.repository;

import com.rapidtech.individu.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByFirstMidNameOrLastNameContaining(String firstName, String lastName);
    List<Student> findTop5ByOrderByIdAsc();
}
