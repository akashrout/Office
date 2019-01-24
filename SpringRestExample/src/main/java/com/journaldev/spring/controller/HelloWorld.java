package com.journaldev.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.model.Employee;

@Controller
public class HelloWorld {
	
	
	@Autowired
	private HelloService helloService;
	
	
	
	public HelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}

	@RequestMapping(value="home" ,method=RequestMethod.GET)
	public String helloworld() {
		
		return "home";
	}
	
	@RequestMapping(value="/" ,method=RequestMethod.GET)
	public ModelAndView gettime() {
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("home"); 
		modelAndView.addObject("serverTime", helloService.getTime());
		return modelAndView;
	}
	
	
	@RequestMapping(value="/displayemployee" ,method=RequestMethod.GET)
	public ModelAndView displayEmployee() {
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("employee");
		modelAndView.addObject("id", emp.getId());
		modelAndView.addObject("name", emp.getName());
		modelAndView.addObject("createdDate", emp.getCreatedDate());
		return modelAndView;
	}

}
