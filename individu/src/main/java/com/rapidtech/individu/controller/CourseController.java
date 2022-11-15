package com.rapidtech.individu.controller;

import com.rapidtech.individu.dto.*;
import com.rapidtech.individu.model.Enrollment;
import com.rapidtech.individu.service.CourseService;
import com.rapidtech.individu.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/course")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    @GetMapping
    public List<CourseResDto> findAllCourse(){
        return courseService.findAllCourse();
    }

    @GetMapping("/{id}")
    public CourseResDto findCourseById(@PathVariable("id") Long id){
        return courseService.findCourseById(id);
    }

    @GetMapping("/title")
    public List<CourseResDto> findCourseByTitle(@RequestParam(name= "title") String title){
        return courseService.findCourseByTitle(title);
    }

    @GetMapping("/students")
    public List<CourseWithStudentResDto> findCourseWithStudent(){
        return courseService.findCourseWithStudent();
    }

    @GetMapping("/student/{id}")
    public CourseWithStudentResDto findCourseByIdWithStudent(@PathVariable("id") Long courseId){
        return courseService.findCourseByIdWithStudent(courseId);
    }

    @PostMapping
    public CourseResDto insertCourse(@RequestBody CourseReqDto courseReqDto){
        return courseService.insertCourse(courseReqDto);
    }

    @PostMapping("/newstudent")
    public String newStudentToCourse(@RequestBody NewStudentToCourseReqDto newStudentToCourseReqDto){
        enrollmentService.newStudentToCourse(newStudentToCourseReqDto);
        return "Berhasil menambahkan student baru ke course id " + newStudentToCourseReqDto.getCourseId().toString();
    }

    @PutMapping
    public CourseResDto updateCourse(@RequestBody CourseResDto courseResDto){
        return courseService.updateCourse(courseResDto);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return "Sukses menghapus course id " + id;
    }


    @DeleteMapping("/allstudents/{courseId}")
    public List<EnrollmentResDto> findByCourseId(@PathVariable(value = "courseId") Long courseId){
        return enrollmentService.findByCourseId(courseId);
    }

    @DeleteMapping("/student/{courseId}/{studentId}")
    public String findByStudentAndCourseId(@PathVariable(value = "courseId") Long courseId, @PathVariable(value = "studentId") Long studentId){
        enrollmentService.findByCourseIdAndStudentId(courseId, studentId);
        return "Berhasil menghapus student id " + studentId.toString() + " dari course id " + courseId.toString();
    }

}
