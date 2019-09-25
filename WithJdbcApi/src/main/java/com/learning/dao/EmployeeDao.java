package com.learning.dao;

import java.util.List;

import com.learning.model.Employee;

/**
 * 
 * @author santoshkumarkar
 *
 */
public interface EmployeeDao {

	public Employee findById(long id);
	
	public void save(Employee emp);
	
	public void remove(long id);

	public void update(long id, Employee emp);
	
	public List<Employee> findAll();
}
