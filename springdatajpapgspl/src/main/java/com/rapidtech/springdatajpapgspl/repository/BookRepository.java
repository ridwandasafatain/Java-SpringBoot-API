package com.rapidtech.springdatajpapgspl.repository;

import com.rapidtech.springdatajpapgspl.model.Book;
import com.rapidtech.springdatajpapgspl.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByWritter(String writter);
    List<Book> findAllByWritterContaining(String writter);
    Book findByIsbn(String isbn);
    List<Book> findAllByIsbnContaining(String isbn);
    List<Book> findAllByBookCategory(BookCategory bookCat);


    @Query(nativeQuery = true, value = "select * from book order by title")
    List<Book> findALlByQueryNative();

    @Query(nativeQuery = true, value = "select * from book where writter = ?1")
    List<Book> findAllByWritterNative(String writter);
}
