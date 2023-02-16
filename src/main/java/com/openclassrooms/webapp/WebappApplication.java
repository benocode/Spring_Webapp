package com.openclassrooms.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.webapp.repository.EmployeeProxy;

@SpringBootApplication
public class WebappApplication implements CommandLineRunner {

	@Autowired
	private EmployeeProxy prox;
	
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(prox.getEmployees());
		
	}
	
	
}
