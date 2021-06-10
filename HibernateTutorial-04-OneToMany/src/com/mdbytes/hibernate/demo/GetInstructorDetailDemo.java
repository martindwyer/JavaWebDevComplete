package com.mdbytes.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Instructor;
import com.mdbytes.hibernate.demo.entity.InstructorDetail;
import com.mdbytes.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

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
			
			// get the instructor detail object 
			
			
			// print the instructor detail
			
			
			// print the associated instructor
			
			int theId = 2;
			
			InstructorDetail details = session.get(InstructorDetail.class,theId);

			System.out.println("details: " + details);
			
			System.out.println("details: " + details.getInstructor());
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			
			factory.close();
		}
	}

}
