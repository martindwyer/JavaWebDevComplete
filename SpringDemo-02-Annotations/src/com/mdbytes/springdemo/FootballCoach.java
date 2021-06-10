package com.mdbytes.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAddress;
	
	public FootballCoach() {
		
	}
	
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Autowired
	public void generateEmailAddress() {
		this.emailAddress = "martin@mdbytes.com";
	}


	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run 40 yard sprints for 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("Doing my start up stuff for " + this);
	}
	
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("Doing my clean up stuff for ");
	}
	
	
	

}
