package com.hitss.springboot.userapp.models;

import java.time.LocalDate;

public class User {
    private String name;
    private String lastname;
    private LocalDate birthDate;
    private String email;
    
    public User(String name, String lastname, LocalDate birthDate) {
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
