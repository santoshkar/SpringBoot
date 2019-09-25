package com.learning.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.model.Employee;

/**
 * 
 * @author santoshkumarkar
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Employee findById(long id) {

		Map<String, Long> map = new HashMap<String, Long>();
		map.put("empId", id);

		return jdbcTemplate.queryForObject("SELECT id, name, email, dept_id " + "FROM EMP " + "WHERE id = :empId", map,
				new EmployeeRowMapper());
	}

	public List<Employee> findAll() {
		return jdbcTemplate.query("SELECT id, name, email, dept_id " + "FROM emp", new EmployeeRowMapper());
	}

	@Override
	public void save(Employee emp) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", emp.getName());
		map.put("email", emp.getEmail());
		map.put("deptId", emp.getDeptId());
		jdbcTemplate.update("INSERT INTO emp(name, email, dept_id) VALUES (:name, :email, :deptId)", map);
	}

	@Override
	public void update(long id, Employee emp) {

		Employee employee = findById(id);
		if (employee == null) {
			throw new RuntimeException("EMP not found");
		}

		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", emp.getName());
		map.put("email", emp.getEmail());
		map.put("deptId", emp.getDeptId());
		jdbcTemplate.update("UPDATE emp set name=:name, email=:email, dept_id=:deptId " + " WHERE id=:id", map);
	}

	@Override
	public void remove(long id) {
		Employee employee = findById(id);
		if (employee == null) {
			throw new RuntimeException("EMP not found");
		}

		Map<String, Object> map = new HashMap<>();
		map.put("id", id);

		jdbcTemplate.update("DELETE FROM emp " + " WHERE id=:id", map);
	}
}
