package com.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.entity.Employee;

@SpringBootApplication
@RestController
public class RestfulWithJUnitApplication implements CommandLineRunner {

	@Autowired
	private Employee emp = null;
	
	@Override
	public void run(String... args) {
		emp.setId(1L);
		emp.setName("Santosh");
		emp.setDepartment("IT");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RestfulWithJUnitApplication.class, args);
	}
	
	@RequestMapping("/")
	private Employee showEmpDetails(){
		return emp;
	}
	
	
}
