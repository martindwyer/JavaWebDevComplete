package com.mdbytes.crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdbytes.crud.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
