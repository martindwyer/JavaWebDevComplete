package com.mdbytes.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDBUtil studentDBUtil;

	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		try {

			studentDBUtil = new StudentDBUtil(dataSource);

		} catch (Exception e) {

			throw new ServletException(e);

		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			
			switch(theCommand) {
				case "LIST":
					listStudents(request,response);
					break;
				
				case "ADD":
					addStudent(request,response);
					break;
				
				case "LOAD":
					loadStudent(request,response);
					break;
					
				case "UPDATE":
					updateStudent(request,response);
					break;
				
				case "DELETE":
					deleteStudent(request,response);
					break;
					
					
				default:
					listStudents(request,response);
			}
		
					
		
		} catch (Exception e) {
			
			throw new ServletException(e);
		
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get student id from the request
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		
		// delete student from db
		studentDBUtil.deleteStudent(studentId);
		
		// return user to student list
		listStudents(request,response);
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from form data
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailAddress");
		
		// create a new student object
		Student student = new Student(id,firstName,lastName,emailAddress);
		
		// perform update on database
		studentDBUtil.updateStudent(student);
		
		// send user back to list students page
		listStudents(request,response);
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student id
		String studentId = request.getParameter("studentId");
		
		// get student id from database
		Student student = studentDBUtil.getStudent(studentId);
		
		// place student in request attribute
		request.setAttribute("THE_STUDENT",student);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request,response);
		
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from the form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailAddress");
		
		// create a new student object
		Student student = new Student(firstName, lastName, emailAddress);
		
		// add the student to the database
		studentDBUtil.addStudent(student);
		
		// send back to main page (the student list)
		listStudents(request,response);
		
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db
		List<Student> students = studentDBUtil.getStudents();
		
		// add students to request object
		request.setAttribute("STUDENT_LIST", students);

		// send to jsp using request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);

	}

}
