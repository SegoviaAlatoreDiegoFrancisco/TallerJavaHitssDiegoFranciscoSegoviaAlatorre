package com.hitss.springboot.web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hitss.springboot.web.models.Product;
import com.hitss.springboot.web.repositories.ProductRepository;
import com.hitss.springboot.web.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    //Inyeccción de dependencia -> atributo, método set, constructor

    private final ProductRepository repository;
    
    public ProductServiceImpl( @Qualifier("productJson") ProductRepository repository) {
        this.repository = repository;
    }
    
    //@Autowired
    //public void setRepository(ProductRepository repository) {
    //    this.repository = repository;
    //}
    
    //@Autowired
    @Override
    public List<Product> findAll() {
        return repository.findAll().stream()
                        .map(p -> {
                            Double priceTax = p.getPrice() * 1.45;
                            Product newProduct;
                            try {
                                newProduct = (Product) p.clone();
                                newProduct.setPrice(priceTax);
                            } catch (CloneNotSupportedException e) {
                                newProduct = new Product(p.getId(), p.getName(), priceTax);
                            }
                            //Product newProduct = new Product(p.getId(),p.getName(), priceTax);
                            //p.setPrice(priceTax);
                            return newProduct;
                        })
                        .toList();
                        
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
    

}
