package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController  {
	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello World by Santosh";
	}


	@RequestMapping(value = "/getEmp", method=RequestMethod.GET)
	public Employee getEmployee(){
		
		Department d = new Department(1, "Software");
		Employee e = new Employee(100, "Santosh", d);
		
		return e;
		
	}
	
}
