package com.mdbytes.mvc.demo.mvctwo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
	
	public static List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("Mary","Public","mary@luv2code.com"));
		students.add(new Student("John","Doe","john@luv2code.com"));
		students.add(new Student("Fred","Flintstone","fred@luv2code.com"));
		students.add(new Student("Barney","Rubble","barney@luv2code.com"));
		
		return students;
	}

}
