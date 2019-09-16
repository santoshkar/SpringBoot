package com.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee>  getEmployee(@PathVariable("id") Long id) 
			throws EmployeeNotFoundException{
		Employee emp = empService.getEmployee(id);
		ResponseEntity<Employee> e = 
				new ResponseEntity<Employee>(emp, HttpStatus.FOUND);
		return e;
	}
}
