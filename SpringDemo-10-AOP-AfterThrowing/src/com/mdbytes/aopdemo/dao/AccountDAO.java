package com.mdbytes.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mdbytes.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;

	public void addAccount(Account account) {
		
		System.out.println(getClass() + ": Doing My DB Work:  Adding an account.");
	}
	
	public List<Account> findAccounts(boolean tripWire) {
		
		// create the exception logic
		
		if(tripWire) {
			throw new RuntimeException("No soup for you!!!");
		}
		
		List<Account> accounts = new ArrayList<>();
		
		// create sample accounts
		
		Account a1 = new Account("John","Silver");
		Account a2 = new Account("Madhu","Platinum");
		Account a3 = new Account("Luca","Gold");
		
		// add accounts to list
		
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		
		return accounts;
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		
		return true;
	}

	public String getName() {
		System.out.println("getName() called");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName() called");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("getServiceCode() called");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("setServiceCode() called");
		this.serviceCode = serviceCode;
	}
	
	
}
