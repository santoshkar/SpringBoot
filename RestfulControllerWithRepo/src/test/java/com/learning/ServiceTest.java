package com.learning;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {EmployeeService.class})
public class ServiceTest {

	@MockBean
	private EmployeeRepository empRepository;
	
	@InjectMocks
	@Autowired
	private EmployeeService empService;
	
	@Test
	public void testFindById() {
		
		when(empRepository.findById(1L)).thenReturn(buildEmployeeMock());
		
		Employee emp = empService.getEmployee(1);
		Assert.notNull(emp, "Emp is null");
		Assert.isTrue("Santosh".equals(emp.getName()), "Name didn't match");
	}
	
	@Test
	public void testFindAll() {
		
		when(empRepository.findAll()).thenReturn(buildEmployeeListMock());
		
		List<Employee> empList = empService.all();
		Assert.notNull(empList, "List found null");
		Assert.notEmpty(empList, "List found empty");
		Assert.isTrue(empList.size() == 1, "Size didn't match");
	}
	
	private Optional<Employee> buildEmployeeMock() {
		Employee e = new Employee();
		e.setId(1L);
		e.setName("Santosh");
		return Optional.of(e);
	}
	
	private List<Employee> buildEmployeeListMock() {
		Employee e = new Employee();
		e.setId(1L);
		e.setName("Santosh");
		return new ArrayList<Employee>() {
			private static final long serialVersionUID = 7210142925339847370L;

			{add(e);}};
	}
}
