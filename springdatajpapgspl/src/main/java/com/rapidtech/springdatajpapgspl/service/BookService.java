package com.rapidtech.springdatajpapgspl.service;

import com.rapidtech.springdatajpapgspl.dto.BookReqDto;
import com.rapidtech.springdatajpapgspl.dto.BookResDto;
import com.rapidtech.springdatajpapgspl.dto.BookWithCategoryResDto;
import com.rapidtech.springdatajpapgspl.model.Book;

import java.util.List;

public interface BookService {
    List<BookResDto> findAllBook();
    List<BookWithCategoryResDto> findAllWithCategory();
    BookResDto findById(Long id);
    BookResDto updateBook(Long id,BookReqDto book);
    BookResDto insertBook(BookReqDto book);
    void deleteBook(Long id);
}
