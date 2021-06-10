package com.mdbytes.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.mdbytes.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;

	public void addAccount(Account account) {
		
		System.out.println(getClass() + ": Doing My DB Work:  Adding an account.");
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
