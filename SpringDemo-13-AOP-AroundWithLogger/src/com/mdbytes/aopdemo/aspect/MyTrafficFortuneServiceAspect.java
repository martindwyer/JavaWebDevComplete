package com.mdbytes.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class MyTrafficFortuneServiceAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.mdbytes.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out the method we are advising on
		myLogger.info("@Around advice  ==>> on getFortune()");

		String method = theProceedingJoinPoint.getSignature().toShortString();

		myLogger.info("@Around method  ==>> " + method);
		
		// get begin timestamp
		
		long begin = System.currentTimeMillis();
		
		// exectue the method
		
		Object result = theProceedingJoinPoint.proceed();
		
		// get ending timestamp
		
		long end = System.currentTimeMillis();
		
		// compute and display duration
		
		long duration = end - begin;
		myLogger.info("Duration: " + duration / 1000.0 + " seconds");
		
		
		return result;
		
	}
	
}
