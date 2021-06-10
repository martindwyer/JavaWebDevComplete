package com.mdbytes.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mdbytes.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		
		TrafficFortuneService trafficFortune = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		// call the business methods
		
		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("Calling getFortune()");
		
		String data = trafficFortune.getFortune();
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
		
		// close the context
		
		context.close();

	}

}
