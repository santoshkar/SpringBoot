package com.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dao.entity.Department;
import com.dao.entity.Employee;

@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Integer>{
	Employee findById(Integer id);
	List<Employee> findByDepartment(Department d);
}
