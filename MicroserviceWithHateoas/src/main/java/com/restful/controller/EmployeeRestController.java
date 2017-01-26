package com.restful.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.entity.Employee;

@RestController
public class MyController {
	
	Employee emp;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	HttpEntity<Employee> getEmployee(){
		emp = new Employee();
		emp.setName("Santosh Kumar Kar");
		emp.setEmpId(1L);
		emp.setEmpAddress("Hyderabad");
		
		HttpEntity<Employee> httpEntity = methodOn(MyController.class).getEmployee();
    	Link link = linkTo(httpEntity).withSelfRel();
        emp.add(link);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	HttpEntity<Employee> postEmployee(){
		emp = new Employee();
		emp.setName("Santosh Kumar Kar - post");
		emp.setEmpId(3L);
		emp.setEmpAddress("Hyderabad");
		
		HttpEntity<Employee> httpEntity = methodOn(MyController.class).postEmployee();
    	Link link = linkTo(httpEntity).withSelfRel();
        emp.add(link);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.DELETE)
	HttpEntity<Employee> deleteEmployee(){
		emp = new Employee();
		emp.setName("Santosh Kumar Kar - delete");
		emp.setEmpId(2L);
		emp.setEmpAddress("Hyderabad");
		
		HttpEntity<Employee> httpEntity = methodOn(MyController.class).deleteEmployee();
    	Link link = linkTo(httpEntity).withSelfRel();
        emp.add(link);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
}
