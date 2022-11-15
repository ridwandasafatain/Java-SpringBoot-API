package com.rapidtech.individu.service;

import com.rapidtech.individu.dto.CourseReqDto;
import com.rapidtech.individu.dto.CourseResDto;
import com.rapidtech.individu.dto.CourseWithStudentResDto;

import java.util.List;

public interface CourseService {
    List<CourseResDto> findAllCourse();
    CourseResDto findCourseById(Long id);
    List<CourseWithStudentResDto> findCourseWithStudent();
    CourseWithStudentResDto findCourseByIdWithStudent(Long courseId);
    List<CourseResDto> findCourseByTitle(String title);
    CourseResDto insertCourse(CourseReqDto courseReqDto);
    CourseResDto updateCourse (CourseResDto courseResDto);
    void deleteCourse (Long id);
}
