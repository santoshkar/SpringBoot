package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dao.EmployeeDao;
import com.learning.model.Employee;

/**
 * 
 * @author santoshkumarkar
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService  {

	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public Employee findEmployeeById(long id) {
		return empDao.findById(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return empDao.findAll();
	}

	@Override
	public void createNewEmployee(Employee emp) {
		empDao.save(emp);
		
	}

	@Override
	public void updateEmployee(long id, Employee emp) {
		empDao.update(id, emp);
	}

	@Override
	public void deleteEmployee(long id) {
		empDao.remove(id);
		
	}
}
