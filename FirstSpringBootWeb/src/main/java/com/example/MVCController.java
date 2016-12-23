package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVCController {
	
	@RequestMapping("/hellojsp")
	public ModelAndView hello(){
		
		ModelAndView mv = new ModelAndView("apage");
		mv.addObject("myval", "Model value from MVC Controller...");
		return mv;
	}
	
}
