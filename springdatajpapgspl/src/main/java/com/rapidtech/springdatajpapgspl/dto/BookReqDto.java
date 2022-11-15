package com.rapidtech.springdatajpapgspl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookReqDto {
    private String title;
    private String writter;
    private String isbn;
    private Long categoryId;
}
