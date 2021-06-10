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
		
		Account account = new Account("foobar","silver");
		theAccountDAO.addAccount(account);
		theAccountDAO.doWork();
		
		// call the accountdao getter/setter methods
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();
		
		
		// close the context
		
		context.close();

	}

}
