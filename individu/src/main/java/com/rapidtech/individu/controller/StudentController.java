package com.rapidtech.individu.controller;

import com.rapidtech.individu.dto.EnrollmentReqDto;
import com.rapidtech.individu.dto.StudentReqDto;
import com.rapidtech.individu.dto.StudentResDto;
import com.rapidtech.individu.dto.StudentWithCourseResDto;
import com.rapidtech.individu.service.EnrollmentService;
import com.rapidtech.individu.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;
    private final EnrollmentService enrollmentService;

    @GetMapping
    public List<StudentResDto> findAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("/limit")
    public List<StudentResDto> findAllStudentWithLimit(){

        return studentService.findAllStudentWithLimit();
    }

    @GetMapping("/{id}")
    public StudentResDto findStudentById(@PathVariable("id") Long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/courses")
    public List<StudentWithCourseResDto> findAllStudentWithCourse(){
        return studentService.findAllStudentWithCourse();
    }

    @GetMapping("/name")
    public List<StudentResDto> findStudentByName(@RequestParam(name = "name") String name){
        return studentService.findStudentByName(name);
    }

    @GetMapping("/course/{id}")
    public StudentWithCourseResDto findStudentWithCourseById(@PathVariable("id") Long studentId){
        return studentService.findStudentWithCourseById(studentId);
    }

    @PostMapping
    public StudentResDto insertStudent(@RequestBody StudentReqDto studentReqDto){
        return studentService.insertStudent(studentReqDto);
    }

    @PostMapping("/addcourse")
    public String insertStudentToCourse(@RequestBody EnrollmentReqDto enrollmentReqDto){
        enrollmentService.insertStudentToCourse(enrollmentReqDto);
        return "Berhasil menambahkan student id " + enrollmentReqDto.getStudentId().toString() + "ke course id " + enrollmentReqDto.getCourseId().toString();
    }

    @PostMapping("/course/newstudent")
    public String newStudentWithCourse(@RequestBody Long courseId, @RequestBody StudentReqDto studentReqDto){
        studentService.newStudentWithCourse(courseId,studentReqDto);
        return "Berhasil menambahkan student baru ke course id " + courseId.toString();
    }

    @PutMapping
    public StudentResDto updateStudent(@RequestBody StudentResDto studentResDto){
        return studentService.updateStudent(studentResDto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "Berhasil menghapus student id : " + id;
    }
}
