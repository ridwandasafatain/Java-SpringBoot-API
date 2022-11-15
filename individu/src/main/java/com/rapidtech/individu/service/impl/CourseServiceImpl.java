package com.rapidtech.individu.service.impl;

import com.rapidtech.individu.dto.CourseReqDto;
import com.rapidtech.individu.dto.CourseResDto;
import com.rapidtech.individu.dto.CourseWithStudentResDto;
import com.rapidtech.individu.dto.StudentResDto;
import com.rapidtech.individu.model.Course;
import com.rapidtech.individu.model.Enrollment;
import com.rapidtech.individu.model.Student;
import com.rapidtech.individu.repository.CourseRepository;
import com.rapidtech.individu.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<CourseResDto> findAllCourse() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResDto> courseResDtoList = new ArrayList<>();
        for(Course course : courses){
            courseResDtoList.add(CourseResDto.builder()
                    .id(course.getId())
                    .title(course.getTitle())
                    .credit(course.getCredit())
                    .build());
        }
        return courseResDtoList;
    }

    @Override
    public CourseResDto findCourseById(Long id) {
        Course course = courseRepository.findById(id).get();
        CourseResDto courseResDto = new CourseResDto();
        courseResDto.setId(id);
        courseResDto.setTitle(course.getTitle());
        courseResDto.setCredit(course.getCredit());
        return courseResDto;
    }

    @Override
    public List<CourseWithStudentResDto> findCourseWithStudent() {
        List<Course> courses = courseRepository.findAll();
        List<CourseWithStudentResDto> courseWithStudentResDtoList = new ArrayList<>();
        for(Course course : courses){
            List<StudentResDto> studentResDtos = new ArrayList<>();
            for (Enrollment enrollment : course.getEnrollments()){
                studentResDtos.add(StudentResDto.builder().id(enrollment.getStudent().getId())
                        .firstMidName(enrollment.getStudent().getFirstMidName())
                        .lastName(enrollment.getStudent().getLastName())
                        .enrollmentDate(enrollment.getStudent().getEnrollmentDate()).build());
            }
            courseWithStudentResDtoList.add(CourseWithStudentResDto.builder().id(course.getId())
                    .title(course.getTitle()).studentResDtoList(studentResDtos).build());
        }
        return courseWithStudentResDtoList;
    }

    @Override
    public CourseWithStudentResDto findCourseByIdWithStudent(Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        CourseWithStudentResDto courseWithStudentResDto = new CourseWithStudentResDto();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for (Enrollment enrollment : course.getEnrollments()){
            studentResDtoList.add(StudentResDto.builder().id(enrollment.getStudent().getId())
                    .firstMidName(enrollment.getStudent().getFirstMidName())
                    .lastName(enrollment.getStudent().getLastName())
                    .enrollmentDate(enrollment.getStudent().getEnrollmentDate()).build());
        }
        courseWithStudentResDto.setId(course.getId());
        courseWithStudentResDto.setTitle(course.getTitle());
        courseWithStudentResDto.setStudentResDtoList(studentResDtoList);
        return courseWithStudentResDto;
    }

    @Override
    public List<CourseResDto> findCourseByTitle(String title) {
        List<Course> courses = courseRepository.findAllByTitleContaining(title);
        List<CourseResDto> courseResDtoList = new ArrayList<>();
        for (Course course : courses){
            courseResDtoList.add(CourseResDto.builder()
                    .id(course.getId())
                    .title(course.getTitle())
                    .credit(course.getCredit())
                    .build());
        }
        return courseResDtoList;
    }

    @Override
    public CourseResDto insertCourse(CourseReqDto courseReqDto) {
        Course course = new Course();
        course.setTitle(courseReqDto.getTitle());
        course.setCredit(courseReqDto.getCredit());
        Course result = courseRepository.save(course);

        return CourseResDto.builder().id(result.getId()).title(result.getTitle()).credit(result.getCredit()).build();
    }

    @Override
    public CourseResDto updateCourse(CourseResDto courseResDto) {
        Course course = new Course();
        course.setId(courseResDto.getId());
        course.setTitle(courseResDto.getTitle());
        course.setCredit(courseResDto.getCredit());
        Course result = courseRepository.save(course);
        return CourseResDto.builder().id(result.getId()).title(result.getTitle()).credit(result.getCredit()).build();
    }

    @Override
    public void deleteCourse(Long id) {
        Course deleteCourse = courseRepository.findById(id).get();
        courseRepository.delete(deleteCourse);
    }
}
