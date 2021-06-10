package com.mdbytes.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
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

			System.out.println("Creating new student objects");
			Student studentOne = new Student("John","Doe","john@mdbytes.com");
			Student studentTwo = new Student("Mary","Public","mary@mdbytes.com");
			Student studentThree = new Student("Bonita","Applebum","bonita@mdbytes.com");
			// start a transaction
			
			session.beginTransaction();
			
			// save the student object
			
			System.out.println("Saving new student objects");
			session.save(studentOne);
			session.save(studentTwo);
			session.save(studentThree);
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			factory.close();
		}
	}

}
