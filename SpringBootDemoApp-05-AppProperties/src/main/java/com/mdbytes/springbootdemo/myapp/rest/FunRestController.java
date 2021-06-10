package com.mdbytes.springbootdemo.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// inject properties for coach and team names
	
	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;
	
	// end point for injected information
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach:  "  + coachName + ", Team: " + teamName;
	}
	
	
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
