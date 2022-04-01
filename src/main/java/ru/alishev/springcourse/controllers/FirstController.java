package ru.alishev.springcourse.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
	private String messageKey = "message";
	private String messageValue;
	
	@GetMapping("/hello")
	public String sayHello(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		messageValue = "Hi my dear " + name + " " + surname;
		model.addAttribute(messageKey, messageValue);
		
		return "first/hello";
	}
	
	@GetMapping("/goodbay")
	public String sayGString(@RequestParam(value = "name", required = false) String name,
							@RequestParam(value = "surname", required = false) String surname,
							Model model) {
		
		messageValue = "Goodbay my dear" + name + " " + surname;
		model.addAttribute(messageKey, messageValue);
		
		return "first/goodbay";
	}

}
