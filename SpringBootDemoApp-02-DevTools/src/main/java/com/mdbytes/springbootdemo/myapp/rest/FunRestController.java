package com.mdbytes.springbootdemo.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that returns "Hello World"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello world!  The time on the server is " + LocalDateTime.now();
	}
	
	// expose a new end point for "/workout"
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!!";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Things are looking up for you!";
	}
	
	
}
