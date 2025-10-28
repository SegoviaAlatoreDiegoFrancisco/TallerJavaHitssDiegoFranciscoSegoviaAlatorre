package com.hitss.springboot.userapp.models;

import java.time.LocalDate;

public class User {
    private String name;
    private String lastname;
    private LocalDate birthday;
    private String email;
    
    public User() {
    }
    public User(String name, String lastname, LocalDate birthday, String email) {
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.email = email;
    }
    public User(String name, String lastname, LocalDate birthday) {
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
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
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    

}
