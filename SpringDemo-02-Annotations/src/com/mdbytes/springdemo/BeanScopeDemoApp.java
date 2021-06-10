package com.mdbytes.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		Coach footballCoach = context.getBean("footballCoach",Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("Pointing to same object:  " + result);
		
		System.out.println("The coach: " + theCoach);
		
		System.out.println("Alpha coach:  " + alphaCoach);
		
		System.out.println("Football coach:  " + footballCoach);
		
		// 
		
		context.close();

	}

}
