package com.mdbytes.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyPointcutDeclarations {

	// Before addAccount() of any class
	@Pointcut("execution(* com.mdbytes.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.mdbytes.aopdemo.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.mdbytes.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void allButGetterSetter() {
	}
}
