package com.hitss.springboot.web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitss.springboot.web.models.Product;
import com.hitss.springboot.web.services.ProductService;



@RestController
@RequestMapping("/api/products")
public class ProductController {
    //private final ProductService service = new ProductServiceImpl();
    //@Autowired
    private  final ProductService service;

    
    
    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping
    public List<Product> listProducts() {
        return service.findAll();
        
    }
    @GetMapping("{id}")
    public Product showProduct(@PathVariable Long id) {
        return service.findById(id);
    }
    
    
}
