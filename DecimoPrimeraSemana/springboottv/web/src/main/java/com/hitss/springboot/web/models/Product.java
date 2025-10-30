package com.hitss.springboot.web.models;

public class Product implements  Cloneable{
    private Long id;
    private String name;
    private double price;
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // fallback to manual copy (should not happen since we implement Cloneable)
            return new Product(this.getId(), this.getName(), this.getPrice());
        }
    }
    public Product() {
    }
    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
}
