package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.repository.EmployeeDao;

@Controller
public class FirstController {
	
	@Autowired
	private EmployeeDao empDao;
	
	@RequestMapping("/test/{id}")
	public ModelAndView showMessage(ModelAndView mv, @PathVariable(value="id") Integer id){
		mv.setViewName("employeeDetails");
		mv.addObject("emp", empDao.findById(id));
		System.out.println(empDao.findById(id));
		
		/*Department d = new Department();
		d.setId(4);
		List<Employee> elist = empDao.findByDepartment(d);
		
		mv.addObject("emplist", elist);*/
		
		return mv;
		
	}
}
