package com.rapidtech.springdatajpapgspl.repository;

import com.rapidtech.springdatajpapgspl.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
