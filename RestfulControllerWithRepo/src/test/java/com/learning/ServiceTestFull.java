package com.learning;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RestfulControllerWithRepo.class})
public class ServiceTestFull {

	@Autowired
	private EmployeeService empService;
	
	@Test
	public void testFindById() {
		Employee emp = empService.getEmployee(1);
		Assert.notNull(emp, "Emp is null");
		Assert.isTrue("santosh".equals(emp.getName()), "Name didn't match");
	}
	
	@Test
	public void testFindAll() {
		List<Employee> empList = empService.all();
		Assert.notNull(empList, "List found null");
		Assert.notEmpty(empList, "List found empty");
	}	
}
