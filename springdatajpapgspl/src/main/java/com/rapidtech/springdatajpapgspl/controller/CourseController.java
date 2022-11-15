package com.rapidtech.springdatajpapgspl.controller;

import com.rapidtech.springdatajpapgspl.dto.CourseReqDto;
import com.rapidtech.springdatajpapgspl.dto.CourseResDto;
import com.rapidtech.springdatajpapgspl.dto.CourseWithStudentDto;
import com.rapidtech.springdatajpapgspl.dto.CourseWithStudentResDto;
import com.rapidtech.springdatajpapgspl.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/course")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResDto> findAllCourse(){
        return courseService.findAllCourse();
    }

    @PostMapping
    public CourseResDto insertCourse(@RequestBody CourseReqDto courseReqDto){
        return courseService.insertCourse(courseReqDto);
    }

    @PostMapping("/student")
    public String AddStudentToCourse(@RequestBody CourseWithStudentDto courseWithStudentDto){
         courseService.registerStudentToCourse(courseWithStudentDto);
         return "Register student id" + courseWithStudentDto.getCourseId() + "to course id" + courseWithStudentDto.getCourseId()+ "success";
    }

    @GetMapping("/{id}")
    public CourseWithStudentResDto getCourseWithStudentById(@PathVariable("id") Long courseId){
        return courseService.getCourseWithStudentById(courseId);
    }

    @GetMapping("/withstudent")
    public List<CourseWithStudentResDto> getAllCourseWithStudent(){
        return courseService.getAllCourseWithStudent();
    }

}
