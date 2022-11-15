package com.rapidtech.springdatajpapgspl.repository;

import com.rapidtech.springdatajpapgspl.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
