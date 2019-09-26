package com.learning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learning.model.Employee;

/**
 * 
 * @author santoshkumarkar
 *
 */
// @RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDeptId(Long deptId);
	Employee findByEmail(String email);
	Employee findByNameOrEmail(Long id, String email);
}
