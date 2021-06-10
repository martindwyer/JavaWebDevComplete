package com.mdbytes.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Course;
import com.mdbytes.hibernate.demo.entity.Instructor;
import com.mdbytes.hibernate.demo.entity.InstructorDetail;
import com.mdbytes.hibernate.demo.entity.Review;
import com.mdbytes.hibernate.demo.entity.Student;

public class DeleteMaryDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get student
			int theId = 2;
			Student mary = session.get(Student.class, theId);

			session.delete(mary);

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
