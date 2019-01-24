package com.akash;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Add {
	
	@RequestMapping("/add")
	public String add() {
		System.out.println("adding");
	}

}
