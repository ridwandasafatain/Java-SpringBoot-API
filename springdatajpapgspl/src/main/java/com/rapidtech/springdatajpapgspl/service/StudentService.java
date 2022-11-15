package com.rapidtech.springdatajpapgspl.service;

import com.rapidtech.springdatajpapgspl.dto.StudentReqDto;
import com.rapidtech.springdatajpapgspl.dto.StudentResDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    List<StudentResDto> findAllStudent();
    StudentResDto findById(Long id);
    StudentResDto insertStudent(StudentReqDto studentReqDto);
    StudentResDto updateStudent(Long id, StudentReqDto studentReqDto);

    void deleteStudent(Long id);
}
