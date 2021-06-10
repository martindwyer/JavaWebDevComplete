package com.mdbytes.crud.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdbytes.crud.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findAllByOrderByLastNameAsc();

}
