package com.hitss.springboot.web.repositories.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitss.springboot.web.models.Product;
import com.hitss.springboot.web.repositories.ProductRepository;


@Repository("productJson")
public class ProductRepositoryJson implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryJson(){
        Resource resource = new ClassPathResource("json/products.json");
        readValueJson(resource);
    }

    @Override
    public List<Product> findAll() {
        //return Collections.singletonList(new Product(1L,"Monitor Asus 27",4500));
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    private void readValueJson(Resource resource){
        ObjectMapper mapper= new ObjectMapper();
        try {
            data = Arrays.asList(mapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
        }
    }
    
}
