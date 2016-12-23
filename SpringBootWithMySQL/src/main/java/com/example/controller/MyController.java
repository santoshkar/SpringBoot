package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/")
	public String printMessage(){
		System.out.println(jdbcTemplate);
		return "Welcome to Spring Boot : "+jdbcTemplate;
	}
}
