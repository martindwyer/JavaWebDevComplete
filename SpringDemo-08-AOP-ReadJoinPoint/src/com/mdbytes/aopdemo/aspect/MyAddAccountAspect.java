package com.mdbytes.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mdbytes.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyAddAccountAspect {

	@Before("execution(* com.mdbytes.aopdemo.dao.*.addAccount(..))")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("@Before advice  ==>> on addAccountAdvice()");
		
		// display the method signature
		
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display the method arguments
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg: args) {
			
			if(arg instanceof Account) {
				
				Account account = (Account) arg;
				System.out.println("Account name: "  + account.getName());
				System.out.println("Service level: "  + account.getLevel());
				
			}
		}

		
	}

	
	
}
