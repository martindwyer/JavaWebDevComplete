package com.mdbytes.springdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mdbytes.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers(int theSortField);

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);

	
}
