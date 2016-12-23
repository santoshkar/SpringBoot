package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
//or//
//@EnableAutoConfiguration
@Controller
public class SpringBootWebWithAppPropertiesApplication {
	
	@RequestMapping("/hello")
	public ModelAndView hello(ModelAndView mv ){
		mv.setViewName("apage");
		mv.addObject("myval","Value set in controller");
		return mv;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebWithAppPropertiesApplication.class, args);
	}
}
