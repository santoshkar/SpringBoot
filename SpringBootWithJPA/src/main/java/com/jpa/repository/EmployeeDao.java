package com.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dao.entity.Department;
import com.dao.entity.Employee;

@Transactional
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	Employee findById(Integer id);
	List<Employee> findByDepartment(Department d);
}
