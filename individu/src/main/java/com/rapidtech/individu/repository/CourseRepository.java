package com.rapidtech.individu.repository;

import com.rapidtech.individu.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAllByTitleContaining(String title);
}
