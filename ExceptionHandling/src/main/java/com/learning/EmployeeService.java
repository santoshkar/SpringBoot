package com.learning;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


	public Employee getEmployee(long empId) throws EmployeeNotFoundException {
		if (empId != 1) {
			throw new EmployeeNotFoundException("Emp not found with id "+empId);
		}
		
		return new Employee(empId, "Some Name");
	}
	
	
}
