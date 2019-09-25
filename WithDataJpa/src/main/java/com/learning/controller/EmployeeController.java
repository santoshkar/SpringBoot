package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.Employee;
import com.learning.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping(path = "/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		return empService.findEmployeeById(id);
		
	}
	
	@GetMapping(path = "/employee")
	public List<Employee> getAllEmployees() {
		return empService.findAllEmployees();
	}
	
	@PostMapping(path = "/employee")
	public Employee createEmployee(@RequestBody Employee emp) {
		return empService.createNewEmployee(emp);
	}
	
	@PutMapping(path = "/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {
		return empService.updateEmployee(id,  emp);
	}
	
	@DeleteMapping(path = "/employee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		empService.deleteEmployee(id);
		return "success";
	}

}



