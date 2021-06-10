package com.mdbytes.thymeleaf.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mdbytes.thymeleaf.demo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	
	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		
		employees = new ArrayList<Employee>();
		
		employees.add(new Employee(1,"Martin","Dwyer","martin@mdbytes.com"));
		employees.add(new Employee(2,"Rose","Dwyer","rose@mdbytes.com"));
		employees.add(new Employee(3,"Hollyann","Tjelmeland","ha@mdbytes.com"));
		employees.add(new Employee(4,"Kyle","Dwyer","ky@mdbytes.com"));
		employees.add(new Employee(5,"Casey","Dwyer","case@mdbytes.com"));
		employees.add(new Employee(6,"Noah","Dwyer","nono@mdbytes.com"));
		
	}
	
	// add mapping for "/list
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees",employees);
		
		return "list-employees";
		
	}
	
}
