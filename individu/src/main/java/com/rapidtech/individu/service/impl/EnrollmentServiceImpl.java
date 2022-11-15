package com.rapidtech.individu.service.impl;

import com.rapidtech.individu.dto.EnrollmentReqDto;
import com.rapidtech.individu.dto.EnrollmentResDto;
import com.rapidtech.individu.dto.NewStudentToCourseReqDto;
import com.rapidtech.individu.model.Course;
import com.rapidtech.individu.model.Enrollment;
import com.rapidtech.individu.model.Student;
import com.rapidtech.individu.repository.EnrollmentRepository;
import com.rapidtech.individu.repository.StudentRepository;
import com.rapidtech.individu.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;

    @Override
    public void insertStudentToCourse(EnrollmentReqDto enrollmentReqDto) {
        Enrollment enrollment =new Enrollment();
        enrollment.setCourse(Course.builder().id(enrollmentReqDto.getCourseId()).build());
        enrollment.setStudent(Student.builder().id(enrollmentReqDto.getStudentId()).build());
        Enrollment result = enrollmentRepository.save(enrollment);
    }

    @Override
    public void newStudentToCourse(NewStudentToCourseReqDto newStudentToCourseReqDto) {
        Student student = new Student();
        student.setFirstMidName(newStudentToCourseReqDto.getFirstMidName());
        student.setLastName(newStudentToCourseReqDto.getLastName());
        Student newStudent = studentRepository.save(student);

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(Student.builder().id(newStudent.getId()).build());
        enrollment.setCourse(Course.builder().id(newStudentToCourseReqDto.getCourseId()).build());
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteStudentFromCourse(Long studentId, Long courseId) {
        Enrollment enrollment = new Enrollment();
        enrollment.getCourse(Course.builder().id(studentId).build());
        enrollment.getStudent(Student.builder().id(courseId).build());
        enrollmentRepository.delete(enrollment);
    }

    @Override
    public List<EnrollmentResDto> findByCourseId(Long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourseId(courseId);
        List<EnrollmentResDto> enrollmentResDtoList = new ArrayList<>();
        for (Enrollment enrollment : enrollments){
            enrollmentResDtoList.add(EnrollmentResDto.builder()
                    .Id(enrollment.getId())
                    .courseId(enrollment.getCourse().getId())
                    .studentId(enrollment.getStudent().getId()).build());
        }
        enrollmentRepository.deleteAll(enrollments);
        return enrollmentResDtoList;
    }

    @Override
    public EnrollmentResDto findByCourseIdAndStudentId(Long courseId, Long studentId) {
        Enrollment enrollment = enrollmentRepository.findByCourseIdAndStudentId(courseId, studentId);
        EnrollmentResDto enrollmentResDto = new EnrollmentResDto();
        enrollmentResDto.setId(enrollment.getId());
        enrollmentResDto.setCourseId(enrollment.getCourse().getId());
        enrollmentResDto.setStudentId(enrollment.getStudent().getId());
        enrollmentRepository.delete(enrollment);

        return enrollmentResDto;
    }

}
