package com.mdbytes.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// get a new session
			session = factory.getCurrentSession();

			// start a transaction
			session.beginTransaction();

			// retrieve student based on primary key
			System.out.println("\nGetting student with ID: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Get complete : " + myStudent);

			System.out.println("Updating student...");

			myStudent.setFirstName("Scooby");

			// commit
			session.getTransaction().commit();

			// New code
			// get a new session
			session = factory.getCurrentSession();

			// start a transaction
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

			// commit
			session.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			factory.close();
		}
	}

}
