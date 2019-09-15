package com.learning;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee>  getEmployee(@PathVariable("id") Long id) {
		Employee emp = empService.getEmployee(id);
		ResponseEntity<Employee> e = new ResponseEntity<Employee>(emp, HttpStatus.FOUND);
		return e;
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>>  getAll() {
		List<Employee> empList = empService.all();
		ResponseEntity<List<Employee>> e = new ResponseEntity<List<Employee>>(empList, HttpStatus.FOUND);
		return e;
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> savEmployee(@RequestBody Employee employee) {
		Employee emp = empService.savEmployee(employee);
		ResponseEntity<Employee> e = new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		return e;
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathParam("id") long empId) {
		empService.deleteEmployee(empId);
		ResponseEntity<Boolean> e = new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		return e;
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Object> updateEmployee(@PathParam("id") long empId, @RequestBody Employee emp) {
		
		try {
			Employee savedEmp = empService.updateEmployee(empId, emp);
			ResponseEntity<Object> e1 = new ResponseEntity<Object>(savedEmp, HttpStatus.CREATED);
			return e1;
		} catch (Exception e) {
			ResponseEntity<Object> e2 = new ResponseEntity<Object>(false, HttpStatus.NOT_MODIFIED);
			return e2;
		}
		
	}

}
