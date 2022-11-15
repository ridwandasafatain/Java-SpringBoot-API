package com.rapidtech.springdatajpapgspl.service;

import com.rapidtech.springdatajpapgspl.dto.CourseReqDto;
import com.rapidtech.springdatajpapgspl.dto.CourseResDto;
import com.rapidtech.springdatajpapgspl.dto.CourseWithStudentDto;
import com.rapidtech.springdatajpapgspl.dto.CourseWithStudentResDto;

import java.util.List;

public interface CourseService {
    List<CourseResDto> findAllCourse();
    CourseResDto insertCourse(CourseReqDto courseReqDto);
    void registerStudentToCourse(CourseWithStudentDto courseWithStudentDto);
    CourseWithStudentResDto getCourseWithStudentById(Long courseId);
    List<CourseWithStudentResDto> getAllCourseWithStudent();
}
