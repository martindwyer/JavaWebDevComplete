package com.mdbytes.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the initial html form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	

	// need a controller method to process the form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read form data and add data to the Spring model

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the form
		String theName = request.getParameter("studentName");
		
		
		// convert data to all upper case
		theName = theName.toUpperCase();
		
		
		// create message
		
		String result = "Yo " + theName + "!!!";
		
		// add message to Spring model
		model.addAttribute("message",result);
		
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		// read the request parameter from the form
		// String theName = request.getParameter("studentName");
		
		
		// convert data to all upper case
		theName = theName.toUpperCase();
		
		
		// create message
		
		String result = "Hey my friend from v3, " + theName + "!!!";
		
		// add message to Spring model
		model.addAttribute("message",result);
		
		
		return "helloworld";
	}
	
	
}
