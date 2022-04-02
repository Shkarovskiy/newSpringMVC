package ru.alishev.springcourse.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
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
		
		messageValue = "Goodbay my dear " + name + " " + surname;
		model.addAttribute(messageKey, messageValue);
		
		return "first/goodbay";
	}
	
	@GetMapping("/calculator")
	public String calculate(@RequestParam(value = "a", required = false) Integer a,
							@RequestParam(value = "b", required = false) Integer b,
							@RequestParam(value = "operation", required = false) String operation,
							Model model) {
		
		Integer result;
		
		if(operation != null) {
			switch(operation) 
		{
		case "add":
			result =  a + b;
				break;
		case "substract":
			result = a - b;
				break;
		default:
			result = -200;
			}
		} else {
			result = -100;
		}
		System.out.println("debag: " + result);
		
		model.addAttribute("resultOfCalc", "Result of " + a + " " + operation + " " + b + " equals: " + result);
//		model.addAttribute("resultOfCalc", "Result of ");
				
		return "first/calculator";
	}

}
