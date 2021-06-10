package com.mdbytes.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session 
		
		Session session = factory.getCurrentSession();
		
		try {
			// create a java object
			
			System.out.println("Creating new student object");
			Student tempStudent = new Student("Daffy","Duck","daffy@mdbytes.com");
			
			// start a transaction
			
			session.beginTransaction();
			
			// save the student object
			
			System.out.println("Saving new student object");
			session.save(tempStudent);
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Student saved.  Student ID: " + tempStudent.getId());
			
			// Get the student out of the database
			// get a new session
			session = factory.getCurrentSession();
			
			// start a transaction 
			session.beginTransaction();
			
			// retrieve student based on primary key
			System.out.println("\nGetting student with ID: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class,tempStudent.getId());
			
			System.out.println("Get complete : " + myStudent);
			
			// commit
			session.getTransaction().commit();
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			factory.close();
		}
	}

}
