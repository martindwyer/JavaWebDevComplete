package com.mdbytes.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	
	Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	
	@Pointcut("execution(* com.mdbytes.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.mdbytes.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.mdbytes.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display the method being called
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>>> in @Before: calling method: " + method);
		
		// display the arguments submitted with the call
		
		// get the arguments
		
		Object[] args = theJoinPoint.getArgs();
		
		// loog thru and display
		
		for(Object arg: args) {
			myLogger.info("====>>>> argument: " + arg);
		}
		
		
		
	}
	
	// add @AfterReturning advice
	
	@AfterReturning(pointcut="forAppFlow()", returning="theResult")
	public void after(JoinPoint theJoinPoint, Object theResult) {
		
		// display the method being called
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>>> in @AfterReturning: calling method: " + method);
		
		// display the data returning
		
		myLogger.info("=====>>>>> result: " + theResult);
		
				
		
	}
	
}
