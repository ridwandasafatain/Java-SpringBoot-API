package com.rapidtech.individu.service;

import com.rapidtech.individu.dto.StudentReqDto;
import com.rapidtech.individu.dto.StudentResDto;
import com.rapidtech.individu.dto.StudentWithCourseResDto;

import java.util.List;

public interface StudentService {
    List<StudentResDto> findAllStudent();
    List<StudentResDto> findAllStudentWithLimit();
    StudentResDto findStudentById(Long id);
    List<StudentWithCourseResDto> findAllStudentWithCourse();
    StudentWithCourseResDto findStudentWithCourseById(Long studentId);
    List<StudentResDto> findStudentByName(String name);
    StudentResDto insertStudent(StudentReqDto studentReqDto);
    StudentResDto updateStudent(StudentResDto studentResDto);
    void deleteStudent(Long id);

    void newStudentWithCourse(Long courseId, StudentReqDto studentReqDto);
}
