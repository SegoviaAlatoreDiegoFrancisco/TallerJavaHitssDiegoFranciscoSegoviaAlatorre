package com.hitss.springboot.jpa_app;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hitss.springboot.jpa_app.models.Person;
import com.hitss.springboot.jpa_app.repositories.PersonRepository;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner{

	private final PersonRepository repository;
	
	public JpaAppApplication(PersonRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola Spring Boot");		
		list();
	}

	private void list(){
		List<Person> persons = (List<Person>) repository.findAll();
		persons.forEach(System.out::print);
	}
}
