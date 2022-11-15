package com.rapidtech.individu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithCourseResDto {
    private Long id;
    private String firstMidName;
    private String lastName;
    List<CourseResDto> courseResDtoList;
}
