package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee{
	
	@Id
	@GeneratedValue
	private Long id;
	private Integer age;
	private String name;
	
	public Employee() {
		super();
	}
	
	

	public Employee(String name, Integer age) {
		super();
		this.age = age;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", name=" + name + "]";
	}

}