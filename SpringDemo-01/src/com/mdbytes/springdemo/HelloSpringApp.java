package com.mdbytes.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		
		// retrieve a bean from the spring container
		Coach coach = context.getBean("myCoach",Coach.class);
		Coach basketballCoach = context.getBean("basketballCoach",Coach.class);
		Coach baseballCoach = context.getBean("baseballCoach",Coach.class);
		
		// call methods on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		System.out.println(basketballCoach.getDailyWorkout());
		System.out.println(basketballCoach.getDailyFortune());
		
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getDailyFortune());
		
		// close the app context
		context.close();

		
	}

}
