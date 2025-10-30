package com.hitss.springboot.app_jpa_relationship;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppJpaRelationshipApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AppJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando...");
	}

}
