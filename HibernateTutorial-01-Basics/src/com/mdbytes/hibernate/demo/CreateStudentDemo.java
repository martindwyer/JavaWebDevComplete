package com.mdbytes.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent = new Student("Paul","Wall","paul@mdbytes.com");
			
			// start a transaction
			
			session.beginTransaction();
			
			// save the student object
			
			System.out.println("Saving new student object");
			session.save(tempStudent);
			
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
