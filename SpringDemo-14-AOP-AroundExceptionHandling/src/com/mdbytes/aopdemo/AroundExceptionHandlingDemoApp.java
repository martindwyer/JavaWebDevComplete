package com.mdbytes.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mdbytes.aopdemo.service.TrafficFortuneService;

public class AroundExceptionHandlingDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundExceptionHandlingDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		
		TrafficFortuneService trafficFortune = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		// call the business methods
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune()");
		
		boolean tripWire = true;
		
		String data = trafficFortune.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
		// close the context
		
		context.close();

	}

}
