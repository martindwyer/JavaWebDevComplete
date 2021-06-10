package com.mdbytes.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mdbytes.aopdemo.Account;

@Aspect
@Component
@Order(100)
public class MyFindAccountsAspect {

	@AfterReturning(pointcut = "execution(* com.mdbytes.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterFindingAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		System.out.println("@AfterReturning advice  ==>> on findAccounts()");

		String method = joinPoint.getSignature().toShortString();

		System.out.println("@AfterReturning method  ==>> " + method);

		System.out.println("@AfterReturning result  ==>> " + result);
		
		// post-process the data ... before sending back to calling program
		
		convertNameToUpperCase(result);
		
		System.out.println("@AfterReturning result  ==>> " + result);
	}

	private void convertNameToUpperCase(List<Account> result) {
		
		for(Account account: result) {
			account.setName(account.getName().toUpperCase());
		}
		
	}

}
