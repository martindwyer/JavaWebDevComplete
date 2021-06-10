package com.mdbytes.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mdbytes.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction

			session.beginTransaction();

			// query students

			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display the students
			displayStudents(theStudents);

			// query students with last name 'Doe'

			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

			displayStudents(theStudents);

			// query students: lastName 'Doe' or firstName 'Daffy'

			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'")
					.getResultList();
			
			displayStudents(theStudents);
			
			// query students where email like mdbytes
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%mdbytes.com'")
					.getResultList();

			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student s : theStudents) {
			System.out.println(s);
		}
	}

}
