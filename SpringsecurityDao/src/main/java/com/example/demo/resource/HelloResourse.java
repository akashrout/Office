package com.example.demo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/rest/hello")
@RestController
public class HelloResourse {

	
	@GetMapping("/all")
	public String Hello() {
		return "hello";
		
	}
	
	@GetMapping("/secured")
	public String Secured() {
		
		return "secured"; 
	}
}
