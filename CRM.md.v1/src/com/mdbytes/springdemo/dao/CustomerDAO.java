package com.mdbytes.springdemo.dao;

import java.util.List;

import com.mdbytes.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers(int theSortField);

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);
}
