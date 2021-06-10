package com.mdbytes.crud.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mdbytes.crud.demo.entity.Employee;

@Repository
public class EmpDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager 
	private EntityManager entityManager;
	
	// set up constructor injection 
	@Autowired
	public EmpDAOHibernateImpl(EntityManager theEntityManager) {
		
		this.entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
		
		// execute query and get result
		List<Employee> employees = query.getResultList();
		
		// return results
		
		return employees;
	}


	@Override
	public Employee findById(int theId) {
			
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Employee employee = currentSession.get(Employee.class, theId);
		
		// return results
		return employee;
	}


	@Override
	public void save(Employee theEmployee) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		currentSession.saveOrUpdate(theEmployee);
						
	}


	@Override
	public void deleteById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", theId);

		query.executeUpdate();

	}

}
