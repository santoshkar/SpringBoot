package com.restful;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.restful.entity.Employee;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroserviceWithHateoasApplicationTests {

	@Test
	public void testEmployeeGetService() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject("http://localhost:8080/employee", Employee.class);
		Long id = emp.getEmpId();
		String name = emp.getName();
		System.out.println(id);
		System.out.println(name);
		Assert.assertEquals(name, "Santosh Kumar Kar");
		Assert.assertSame(id.longValue(), id.longValue());
	}
	
	@Test
	public void testEmployeePostService() {
		RestTemplate restTemplate = new RestTemplate();
		
		 Employee newEmployee = new Employee(10L, "Santosh", "HR");
		Employee emp = restTemplate.postForObject("http://localhost:8080/employee", newEmployee, Employee.class);
		Long id = emp.getEmpId();
		String name = emp.getName();
		System.out.println(id);
		System.out.println(name);
		Assert.assertEquals(name, "Santosh Kumar Kar");
		Assert.assertSame(id.longValue(), id.longValue());
	}

}
