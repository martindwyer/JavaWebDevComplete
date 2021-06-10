package com.mdbytes.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Course;
import com.mdbytes.hibernate.demo.entity.Instructor;
import com.mdbytes.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		// create session 
		
		Session session = factory.getCurrentSession();
		
		try {
			// create a java object
			
			Instructor tempInstructor = new Instructor("Marty","Dwyer","marty@mdbytes.com");
			
			InstructorDetail details = new InstructorDetail("http://www.mdbytes.com/youtube","Fitness");
			
			tempInstructor.setInstructorDetail(details);
			
			// start a transaction
			
			session.beginTransaction();
			
			// save the instructor object
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
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
