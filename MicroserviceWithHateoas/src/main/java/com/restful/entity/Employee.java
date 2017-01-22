package com.restful.entity;

import org.springframework.hateoas.ResourceSupport;

public class Employee extends ResourceSupport{

	private String name;
	private Long empId;
	private String empAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	
}
