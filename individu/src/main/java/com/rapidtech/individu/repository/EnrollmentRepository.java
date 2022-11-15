package com.rapidtech.individu.repository;

import com.rapidtech.individu.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    Enrollment findByCourseIdAndStudentId(Long courseId, Long studentId);
    List<Enrollment> findByCourseId(Long courseId);

    void deleteAllByCourseId(Long courseId);

}
