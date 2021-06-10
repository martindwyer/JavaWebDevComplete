package com.mdbytes.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// Before addAccount() of any class 
	@Pointcut("execution(* com.mdbytes.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {	}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("Executing @Before advice on addAccountAdvice()");
		
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("Doing some fancy analytics for the API...");
	}
	
	
	
	
}
