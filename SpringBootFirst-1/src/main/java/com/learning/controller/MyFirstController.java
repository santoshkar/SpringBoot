package com.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {
	
	//@RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
	@GetMapping(path = "/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		
		if (id == 1)
			return new Employee(1, "Sudhakar", "IT");	//Got from DB
		else if (id == 2)
			return new Employee(2, "Nirmala", "HR");
		else if (id == 3)
			return new Employee(3, "Rohit", "INFRA");
		else throw new RuntimeException("Emp not found");
	}
	
	//@RequestMapping(path = "/employee", method = RequestMethod.GET)
	@GetMapping(path = "/employee")
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Sudhakar", "IT"));
		empList.add(new Employee(2, "Nirmala", "HR"));
		empList.add(new Employee(3, "Rohit", "INFRA"));
		return empList;										//Got all emps from DB
	}
	
	//@RequestMapping(path = "/employee", method = RequestMethod.POST)
	@PostMapping(path = "/employee")
	public Employee createEmployee(@RequestBody Employee emp) {
		System.out.println("New employee created: "+emp);	  		//Inserted in DB
		return emp;	//Got from DB new entity
	}
	
	//@RequestMapping(path = "/employee/{id}", method = RequestMethod.PUT)
	@PutMapping(path = "/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {
		System.out.println("Updating the employee"+emp);	  		//Inserted in DB
		return emp;	//Got from DB new entity
	}

}



