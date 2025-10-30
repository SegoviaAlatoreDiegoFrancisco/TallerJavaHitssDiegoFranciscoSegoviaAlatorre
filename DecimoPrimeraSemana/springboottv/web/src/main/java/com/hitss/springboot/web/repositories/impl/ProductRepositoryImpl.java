package com.hitss.springboot.web.repositories.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.hitss.springboot.web.models.Product;
import com.hitss.springboot.web.repositories.ProductRepository;
//@Primary 
@Repository("productImp")
public class ProductRepositoryImpl implements ProductRepository{
    private final List<Product> products;

    public ProductRepositoryImpl() {
        this.products = List.of(
            new Product(1L, "Memoria RamKingston Fury 8GB)", 450),
            new Product(2L, "Memoria RamKingstonFury 16GB", 800),
            new Product(3L, "Fuente de podel Stylos 450W", 520.50),
            new Product(4L, "Procesador Intel Core I3 3200", 850),
            new Product(5L, "Monitor 19 pulgadas Stylos", 1550)
            );
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id))
                        .findFirst()
                        .orElseThrow(null); 
    }
	
}
