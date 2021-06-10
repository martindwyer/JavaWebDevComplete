package com.mdbytes.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class MyTrafficFortuneServiceAspect {
	
	
	@Around("execution(* com.mdbytes.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out the method we are advising on
		System.out.println("@Around advice  ==>> on getFortune()");

		String method = theProceedingJoinPoint.getSignature().toShortString();

		System.out.println("@Around method  ==>> " + method);
		
		// get begin timestamp
		
		long begin = System.currentTimeMillis();
		
		// exectue the method
		
		Object result = theProceedingJoinPoint.proceed();
		
		// get ending timestamp
		
		long end = System.currentTimeMillis();
		
		// compute and display duration
		
		long duration = end - begin;
		System.out.println("Duration: " + duration / 1000.0 + " seconds");
		
		
		return result;
		
	}
	
}
