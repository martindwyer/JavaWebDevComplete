package com.mdbytes.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Course;
import com.mdbytes.hibernate.demo.entity.Instructor;
import com.mdbytes.hibernate.demo.entity.InstructorDetail;
import com.mdbytes.hibernate.demo.entity.Review;
import com.mdbytes.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session 
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			
			Course course = new Course("Pacman - How to Score One Million Points");
			
			// save the course ... leveraging cascade all.
			
			session.save(course);
			
			// create the students
			Student s1 = new Student("John","Doe","john@mdbytes.com");
			Student s2 = new Student("Mary","Public","mary@mdbytes.com");
			Student s3 = new Student("Quinton","Jones","quint@mdbytes.com");
			Student s4 = new Student("Ben","Nelson","ben@mdbytes.com");

			course.addStudent(s1);
			course.addStudent(s2);
			course.addStudent(s3);
			course.addStudent(s4);
			
			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.save(s4);
			
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
