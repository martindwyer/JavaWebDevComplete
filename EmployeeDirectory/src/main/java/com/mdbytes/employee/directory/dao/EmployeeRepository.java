package com.mdbytes.employee.directory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdbytes.employee.directory.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findAllByOrderByLastNameAsc();

}
