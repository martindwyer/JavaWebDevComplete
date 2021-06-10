package com.mdbytes.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config file from java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean from container
		
		// tennis coach uses constructor injection
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		// football coach uses setter injection
		// football coach uses method injection
		Coach footballCoach = context.getBean("footballCoach",Coach.class);
				
		// baseball coach uses setter injection
		// baseball coach uses field injection
		Coach baseballCoach = context.getBean("baseballCoach",Coach.class);		
				
		SwimCoach swimCoach = context.getBean("swimCoach",SwimCoach.class);		
				
		
		
		// call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmailAddress());
		
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyFortune());
		System.out.println(footballCoach.getEmailAddress());
		
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getDailyFortune());
		System.out.println(baseballCoach.getEmailAddress());

		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());
		System.out.println(swimCoach.getEmailAddress());
		System.out.println(swimCoach.getTeam());
		
		// close the container
		context.close();
		
	}

}
