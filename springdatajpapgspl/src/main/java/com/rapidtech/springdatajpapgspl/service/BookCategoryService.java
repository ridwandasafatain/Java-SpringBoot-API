package com.rapidtech.springdatajpapgspl.service;

import com.rapidtech.springdatajpapgspl.dto.BookCategoryReqDto;
import com.rapidtech.springdatajpapgspl.dto.BookCategoryResDto;
import com.rapidtech.springdatajpapgspl.model.BookCategory;

import java.util.List;

public interface BookCategoryService {
    List<BookCategoryResDto> findAllBookCategory();
    BookCategoryResDto findBookCategoryById(Long id);
    BookCategory saveOrUpdateBookCategory(BookCategory bookCategory);
    BookCategoryResDto updateBookCategory(Long id, BookCategoryReqDto bookCategoryReqDto);
    BookCategoryResDto insertBookCategory(BookCategoryReqDto bookCategoryReqDto);
    void deleteBookCategory(Long id);
}
