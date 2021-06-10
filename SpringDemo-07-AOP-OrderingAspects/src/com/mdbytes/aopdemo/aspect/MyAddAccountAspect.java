package com.mdbytes.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAddAccountAspect {

	@Before("execution(* com.mdbytes.aopdemo.dao.*.addAccount(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("@Before advice  ==>> on addAccountAdvice()");
		
	}

	
	
}
