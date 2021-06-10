package com.mdbytes.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	

	@Before("com.mdbytes.aopdemo.aspect.MyPointcutDeclarations.allButGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("@Before advice ==>>  Doing some fancy analytics for the API...");
	}

}
