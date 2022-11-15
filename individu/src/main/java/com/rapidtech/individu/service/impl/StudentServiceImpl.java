package com.rapidtech.individu.service.impl;

import com.rapidtech.individu.dto.CourseResDto;
import com.rapidtech.individu.dto.StudentReqDto;
import com.rapidtech.individu.dto.StudentResDto;
import com.rapidtech.individu.dto.StudentWithCourseResDto;
import com.rapidtech.individu.model.Course;
import com.rapidtech.individu.model.Enrollment;
import com.rapidtech.individu.model.Student;
import com.rapidtech.individu.repository.CourseRepository;
import com.rapidtech.individu.repository.EnrollmentRepository;
import com.rapidtech.individu.repository.StudentRepository;
import com.rapidtech.individu.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Override
    public List<StudentResDto> findAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for(Student student : students){
            studentResDtoList.add(StudentResDto.builder()
                    .id(student.getId())
                    .firstMidName(student.getFirstMidName())
                    .lastName(student.getLastName())
                    .enrollmentDate(student.getEnrollmentDate())
                    .build());
        }
        return studentResDtoList;
    }

    @Override
    public List<StudentResDto> findAllStudentWithLimit() {
        List<Student> students = studentRepository.findTop5ByOrderByIdAsc();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for(Student student : students){
            studentResDtoList.add(StudentResDto.builder()
                    .id(student.getId())
                    .firstMidName(student.getFirstMidName())
                    .lastName(student.getLastName())
                    .enrollmentDate(student.getEnrollmentDate())
                    .build());
        }
        return studentResDtoList;
    }

    @Override
    public StudentResDto findStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        StudentResDto studentResDto = new StudentResDto();
        studentResDto.setId(student.getId());
        studentResDto.setFirstMidName(student.getFirstMidName());
        studentResDto.setLastName(student.getLastName());
        studentResDto.setEnrollmentDate(student.getEnrollmentDate());
        return studentResDto;
    }

    @Override
    public List<StudentWithCourseResDto> findAllStudentWithCourse() {
        List<Student> students = studentRepository.findAll();
        List<StudentWithCourseResDto> studentWithCourseResDtoList = new ArrayList<>();
        for (Student student : students){
            List<CourseResDto> courseResDtoList = new ArrayList<>();
            for (Enrollment enrollment : student.getEnrollments()){
                courseResDtoList.add(CourseResDto.builder().id(enrollment.getCourse().getId())
                        .title(enrollment.getCourse().getTitle()).credit(enrollment.getCourse().getCredit()).build());
            }
            studentWithCourseResDtoList.add(StudentWithCourseResDto.builder()
                    .id(student.getId())
                    .firstMidName(student.getFirstMidName())
                    .lastName(student.getLastName())
                    .courseResDtoList(courseResDtoList).build());
        }
        return studentWithCourseResDtoList;
    }

    @Override
    public StudentWithCourseResDto findStudentWithCourseById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentWithCourseResDto studentWithCourseResDtoList = new StudentWithCourseResDto();
        List<CourseResDto> courseResDtoList = new ArrayList<>();
        for (Enrollment enrollment : student.getEnrollments()){
            courseResDtoList.add(CourseResDto.builder().id(enrollment.getCourse().getId())
                    .title(enrollment.getCourse().getTitle()).credit(enrollment.getCourse().getCredit()).build());
        }
        studentWithCourseResDtoList.setId(student.getId());
        studentWithCourseResDtoList.setFirstMidName(student.getFirstMidName());
        studentWithCourseResDtoList.setLastName(student.getLastName());
        studentWithCourseResDtoList.setCourseResDtoList(courseResDtoList);

        return studentWithCourseResDtoList;
    }

    @Override
    public List<StudentResDto> findStudentByName(String name) {
        List<Student> students = studentRepository.findAllByFirstMidNameOrLastNameContaining(name,name);
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for(Student student : students){
            studentResDtoList.add(StudentResDto.builder()
                    .id(student.getId())
                    .firstMidName(student.getFirstMidName())
                    .lastName(student.getLastName())
                    .build());
        }
        return studentResDtoList;
    }

    @Override
    public StudentResDto insertStudent(StudentReqDto studentReqDto) {
        Student student = new Student();
        student.setFirstMidName(studentReqDto.getFirstMidName());
        student.setLastName(studentReqDto.getLastName());
        Student result =  studentRepository.save(student);
        return StudentResDto.builder().id(result.getId()).firstMidName(result.getFirstMidName())
                .lastName(result.getLastName()).build();
    }

    @Override
    public StudentResDto updateStudent(StudentResDto studentResDto) {
        Student student = new Student();
        student.setId(studentResDto.getId());
        student.setFirstMidName(studentResDto.getFirstMidName());
        student.setLastName(studentResDto.getLastName());
        Student result = studentRepository.save(student);
        return studentResDto;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void newStudentWithCourse(Long courseId, StudentReqDto studentReqDto) {
        Student student = new Student();
        student.setFirstMidName(studentReqDto.getFirstMidName());
        student.setLastName(studentReqDto.getLastName());
        Student newStudent = studentRepository.save(student);

//        Enrollment enrollment = enrollmentRepository.findByCourse_id(courseId);
        Student findStudent = studentRepository.findById(newStudent.getId()).get();
        Enrollment newEnrollment = new Enrollment();
        newEnrollment.setStudent(Student.builder().id(findStudent.getId()).build());
        newEnrollment.setCourse(Course.builder().id(courseId).build());
        enrollmentRepository.save(newEnrollment);

    }
}
