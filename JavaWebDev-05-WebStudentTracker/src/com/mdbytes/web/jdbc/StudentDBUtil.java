package com.mdbytes.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDBUtil {

	private DataSource dataSource;
	
	public StudentDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try {
			// get a connection 
			myConn = dataSource.getConnection();
			
			
			// create sql statement
			String sql = "select * from student order by last_name";
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set 
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String emailAddress = myRs.getString("email");
				Student student = new Student(id,firstName,lastName,emailAddress);
				students.add(student);
			}
			
			return students;
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			// close JDBC objects
			close(myConn,myStmt,myRs);
			
		}
		
		return students;
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void addStudent(Student student) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get a connection 
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "insert into student "
							+ "(first_name,last_name,email) "
							+ "values (?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setString(1, student.getFirstName());
			myStmt.setString(2, student.getLastName());
			myStmt.setString(3, student.getEmailAddress());
			
			// Execute query
			myStmt.execute();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			// close JDBC objects
			close(myConn,myStmt,null);
			
		}
		
		
		
	}

	public Student getStudent(String studentId) throws Exception {
		Student student = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		int studentIdNumber;
		
		try {
			studentIdNumber = Integer.parseInt(studentId);
			String firstName = null,lastName = null,emailAddress = null;
			myConn = dataSource.getConnection();
			String sql = "select * from student where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, studentIdNumber);
			myRs = myStmt.executeQuery();
			if(myRs.next()) {
				firstName = myRs.getString("first_name");
				lastName = myRs.getString("last_name");
				emailAddress = myRs.getString("email");
			}
			
			student = new Student(studentIdNumber,firstName,lastName,emailAddress);
			
		
			return student;
			
		} catch (Exception e) {
			
			throw new Exception("Count not find student id: " + studentId );
			
		} finally {
			
			// close JDBC objects
			close(myConn,myStmt,null);
			
		}
		
	}

	public void updateStudent(Student theStudent) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update student "
						+ "set first_name=?, last_name=?, email=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmailAddress());
			myStmt.setInt(4, theStudent.getId());
			
			// execute SQL statement
			myStmt.execute();
			
		} catch (Exception e) {
			
			throw new Exception();
			
		} finally {
			
			// close JDBC objects
			close(myConn,myStmt,null);
			
		}
			
		
	}

	public void deleteStudent(int studentId) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "delete from student where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, studentId);
			
			// execute SQL statement
			myStmt.execute();
			
		} catch (Exception e) {
			
			throw new Exception();
			
		} finally {
			
			// close JDBC objects
			close(myConn,myStmt,null);
			
		}
		
	}
	
}
