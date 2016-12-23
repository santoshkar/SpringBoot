package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootWithInMemoryDbApplication {

	@Autowired
	private UserService ps;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithInMemoryDbApplication.class, args);
	}
	
	@RequestMapping("/")
	public String showMsg(){
		
		//User p1 = new User("Santosh", "kar", 76, "Hyderabad");
		//User p2 = new User("John", "Mathia", 43, "Chicago");
		
		//ps.addPerson(p1);
		//ps.addPerson(p2);
		
		List<User> all = ps.getAllUsers();
		
		return "Hello World santosh "+all;
	}
}
