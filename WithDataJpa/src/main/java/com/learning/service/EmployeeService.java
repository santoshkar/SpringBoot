package com.learning.service;

import java.util.List;

import com.learning.model.Employee;

/**
 * 
 * @author santoshkumarkar
 *
 */
public interface EmployeeService {

	public Employee findEmployeeById(long id);
	public List<Employee> findAllEmployees();
	public Employee createNewEmployee(Employee emp);
	public void deleteEmployee(long id);
	public Employee updateEmployee(long id, Employee emp);


}
