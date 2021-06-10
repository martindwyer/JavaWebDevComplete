package com.mdbytes.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mdbytes.springdemo.entity.Customer;
import com.mdbytes.springdemo.utils.SortUtils;

@Repository
public class CustomerImplementation implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers(int theSortField) {

		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String theFieldName = null;
		
		switch(theSortField) {
		case SortUtils.FIRST_NAME:
			theFieldName = "firstName";
			break;
			
		case SortUtils.LAST_NAME:
			theFieldName = "lastName";
			break;
			
			
		case SortUtils.EMAIL:
			theFieldName = "email";
			break;
			
		default: 
			theFieldName = "lastName";
			
		
		}
		
		// create a query
		
		String queryString = "from Customer order by " + theFieldName;
		
		Query<Customer> theQuery = currentSession.createQuery(queryString,Customer.class);
		
		// execute query and get result list
		
		List<Customer> customers = theQuery.getResultList();
		
		// return list of customers
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		// save the customer to DB
				
		currentSession.saveOrUpdate(theCustomer);
				
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// read object from DB
		
		Customer customer = currentSession.get(Customer.class,theId);
		
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		// delete object from DB
				
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId",theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
	}

}
