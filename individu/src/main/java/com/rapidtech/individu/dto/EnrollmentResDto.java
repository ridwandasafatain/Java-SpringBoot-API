package com.rapidtech.individu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResDto {
    private Long Id;
    private Long studentId;
    private Long courseId;
}
