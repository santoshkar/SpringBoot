package com.restful;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.restful.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulWithJUnitApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	/*
	 * Run this as JUnit Test
	 */
	@Test
	public void testEmployeeService(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> employee = restTemplate.getForEntity("http://localhost:8080/", Employee.class);
		Employee emp = employee.getBody();
		Assert.assertSame(emp.getId(), 1L);
		Assert.assertEquals(emp.getName(), "Santosh");
		Assert.assertEquals(emp.getDepartment(), "IT");
	}

}
