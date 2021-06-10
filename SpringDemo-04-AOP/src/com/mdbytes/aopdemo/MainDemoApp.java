package com.mdbytes.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mdbytes.aopdemo.dao.AccountDAO;
import com.mdbytes.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		// call the business method
		
		Account account = new Account();
		theAccountDAO.addAccount(account);
		theAccountDAO.doWork();
		
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();
		
		
		// close the context
		
		context.close();

	}

}
