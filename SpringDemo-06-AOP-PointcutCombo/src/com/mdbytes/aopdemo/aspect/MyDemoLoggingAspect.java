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
	
	@Pointcut("execution(* com.mdbytes.aopdemo.dao.*.get*(..))")
	private void getter() {	}
	
	@Pointcut("execution(* com.mdbytes.aopdemo.dao.*.set*(..))")
	private void setter() {	}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void allButGetterSetter() {	}
	
	@Before("allButGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("@Before advice on addAccountAdvice()");
		
	}
	
	@Before("allButGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("@Before advice Doing some fancy analytics for the API...");
	}
	
	
	
	
}
