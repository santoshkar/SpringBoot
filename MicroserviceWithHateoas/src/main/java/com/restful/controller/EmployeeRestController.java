package com.restful.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.HashMap;
import java.util.Map;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.entity.Employee;

@RestController
public class EmployeeRestController {
	
	Map<Long, Employee> employees = new HashMap<>();
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	HttpEntity<Employee> getEmployee(@PathVariable("id") Long	 id){
		
		Employee emp = employees.get(id);
		
		if(emp!=null){
			HttpEntity<Employee> httpEntity = methodOn(EmployeeRestController.class).getEmployee(id);
			Link link = linkTo(httpEntity).withSelfRel();
			emp.add(link);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Employee>(new Employee(), HttpStatus.OK);
		}
        
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	Map<Long, Employee> addEmployee(@RequestBody Employee employee){
		employees.put(employee.getEmpId(), employee);
		return employees;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.DELETE)
	Map<Long, Employee> deleteEmployee(@PathVariable("id") Long	 id){
		employees.remove(id);
		return employees;
	}
}
