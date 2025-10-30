package com.hitss.springboot.jpa_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hitss.springboot.jpa_app.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
    
}
