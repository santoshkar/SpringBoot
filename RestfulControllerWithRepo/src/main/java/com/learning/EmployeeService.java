package com.learning;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	public Employee getEmployee(long empId) {
		if (empRepository.findById(empId).isPresent()) {
			return empRepository.findById(empId).get();
		} else {
			return null;
		}
	}
	
	public List<Employee> all() {
		return empRepository.findAll();
	}

	public Employee savEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	public boolean deleteEmployee(long empId) {
		empRepository.delete(empRepository.getOne(empId));
		return true;
	}

	public Employee updateEmployee(long empId, Employee emp) 
			throws NotFoundException {
		Optional<Employee> opt = empRepository.findById(empId);

		if (opt.get() != null) {
			Employee currentEmp = opt.get();
			currentEmp.setName(emp.getName());
			return empRepository.save(currentEmp);
		} else {
			throw new NotFoundException("Employee not found");
		}

	}
}
