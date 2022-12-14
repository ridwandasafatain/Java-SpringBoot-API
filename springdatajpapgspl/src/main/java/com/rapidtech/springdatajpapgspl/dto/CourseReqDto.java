package com.rapidtech.springdatajpapgspl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseReqDto {
    public String title;
    private int modules;
    private double fee;
}
