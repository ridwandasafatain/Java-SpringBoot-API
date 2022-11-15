package com.rapidtech.springdatajpapgspl.repository;

import com.rapidtech.springdatajpapgspl.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByNameContaining(String name);
    List<Product> findAllByPriceGreaterThan(Double price);
}
