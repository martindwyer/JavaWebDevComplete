package com.mdbytes.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Instructor;
import com.mdbytes.hibernate.demo.entity.InstructorDetail;
import com.mdbytes.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create session 
		
		Session session = factory.getCurrentSession();
		
		try {
			// create a java object
			
			
			// start a transaction
			
			session.beginTransaction();
			
			Instructor tempInstructor = session.get(Instructor.class, 3);
			
			System.out.println("Found instructor: " + tempInstructor);
			
			
			
			
			
			if (tempInstructor != null) {
				
				System.out.println("Deleting instructor: " + tempInstructor);
				
				// will also delete the details object from the details table
				session.delete(tempInstructor);
				
			}
			
			
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
