package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.entity.Department;
import com.dao.entity.Employee;
import com.jpa.repository.EmployeeDao;

@Controller
public class FirstController {
	
	@Autowired
	private EmployeeDao empDao;
	
	@RequestMapping("/")
	public ModelAndView showMessage(ModelAndView mv){
		mv.setViewName("employeeDetails");
		mv.addObject("emp", empDao.findById(1));
		
		Department d = new Department();
		d.setId(4);
		List<Employee> elist = empDao.findByDepartment(d);
		
		mv.addObject("emplist", elist);
		
		return mv;
		
	}
}
