package com.mdbytes.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		// create object
		Coach baseballCoach = new BaseballCoach();
		Coach trackCoach = new TrackCoach();
		
		// use the object
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyWorkout());
	}

}
