package com.mdbytes.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach() {
		this.fortuneService = null;
	}
	
	public TrackCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run sprints for 30 minutes.";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just Do It: " + fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartUpStuff() {
		System.out.println("Track coach doing start up stuff");
	}
	
	// add a destroy method
	public void doMyCleanUpStuff() {
		System.out.println("Track coach doing clean up stuff");
	}
	
}
