package ru.alishev.springcourse.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
	
	@GetMapping("/hello")
	public String sayHello(HttpServletRequest request) {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		System.out.println("Hi " + name + " " + surname);
		return "first/hello";
	}
	
	@GetMapping("/goodbay")
	public String sayGString(@RequestParam(value = "name", required = false) String name,
							@RequestParam(value = "surname", required = false) String surname) {
		
		System.out.println("Goodbay " + name + " " + surname);
		return "first/goodbay";
	}

}
