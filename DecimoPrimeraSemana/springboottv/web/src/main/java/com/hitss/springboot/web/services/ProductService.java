package com.hitss.springboot.web.services;

import java.util.List;

import com.hitss.springboot.web.models.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);    
}
