package com.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.model.Employee;

import java.util.List;

/**
 * 
 * @author santoshkumarkar
 *
 */
//Not a class
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
    List<Employee> findByEmailIn(List<String> emails);
    List<Employee> findByNameAndAndDeptId(String name, Long deptId);
    List<Employee> findByDeptIdNotIn(List<Long> ids);
}


