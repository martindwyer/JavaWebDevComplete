package com.mdbytes.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Course;
import com.mdbytes.hibernate.demo.entity.Instructor;
import com.mdbytes.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from the database
			int theId = 1;
			
			Instructor instructor = session.get(Instructor.class,theId);
			
			// create some courses
			Course courseOne = new Course("Air Guitar - The Ultimate Guide");
			Course courseTwo = new Course("Pinball master class");
			Course courseThree = new Course("Beers around the world");
			
			// add courses to instructor
			instructor.add(courseOne);
			instructor.add(courseTwo);
			instructor.add(courseThree);
			
			// save the courses
			session.save(courseOne);
			session.save(courseTwo);
			session.save(courseThree);
			
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
