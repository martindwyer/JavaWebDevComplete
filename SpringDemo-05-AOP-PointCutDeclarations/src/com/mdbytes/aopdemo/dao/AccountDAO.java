package com.mdbytes.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.mdbytes.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account) {
		
		System.out.println(getClass() + ": Doing My DB Work:  Adding an account.");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		
		return true;
	}
}
