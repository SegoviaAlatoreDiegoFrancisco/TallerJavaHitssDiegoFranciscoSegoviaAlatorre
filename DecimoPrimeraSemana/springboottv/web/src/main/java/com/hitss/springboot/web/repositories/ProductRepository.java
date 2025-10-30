package com.hitss.springboot.web.repositories;

import java.util.List;

import com.hitss.springboot.web.models.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
