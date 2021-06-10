package com.mdbytes.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseballCoach() {
		this.fortuneService = null;
	}
	
	public BaseballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Spend 30 minutes in the batting cage";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
