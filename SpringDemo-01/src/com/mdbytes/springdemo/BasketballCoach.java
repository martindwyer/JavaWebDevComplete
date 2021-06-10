package com.mdbytes.springdemo;

public class BasketballCoach implements Coach {

	private FortuneService fortuneService;
	
	public BasketballCoach() {
		this.fortuneService = null;
	}
	
	public BasketballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Shoot free throws until you make ten in a row";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
