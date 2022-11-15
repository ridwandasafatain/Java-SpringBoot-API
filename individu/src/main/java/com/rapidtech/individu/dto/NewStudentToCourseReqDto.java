package com.rapidtech.individu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewStudentToCourseReqDto {
    private String firstMidName;
    private String lastName;
    private Long courseId;
}
