package com.rapidtech.individu.service;

import com.rapidtech.individu.dto.EnrollmentReqDto;
import com.rapidtech.individu.dto.EnrollmentResDto;
import com.rapidtech.individu.dto.NewStudentToCourseReqDto;
import com.rapidtech.individu.dto.StudentReqDto;
import com.rapidtech.individu.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    void insertStudentToCourse(EnrollmentReqDto enrollmentReqDto);
    void newStudentToCourse(NewStudentToCourseReqDto newStudentToCourseReqDto);
    void deleteStudentFromCourse(Long studentId, Long courseId);
    List<EnrollmentResDto> findByCourseId(Long courseId);
    EnrollmentResDto findByCourseIdAndStudentId(Long courseId, Long studentId);
}
