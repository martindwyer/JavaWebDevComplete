package com.mdbytes.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			int studentId = 2;

			// get a new session
			session = factory.getCurrentSession();

			// start a transaction
			session.beginTransaction();

			// retrieve student based on primary key
			System.out.println("\nGetting student with ID: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			// delete the student
			System.out.println("deleting student: " + myStudent);
			
			//session.delete(myStudent);
			
			session.createQuery("delete from Student where id=2").executeUpdate();

			// commit
			session.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			factory.close();
		}
	}

}
