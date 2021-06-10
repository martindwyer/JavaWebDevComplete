package com.mdbytes.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdbytes.crud.demo.dao.EmployeeRepository;
import com.mdbytes.crud.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {

		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee employee = null;
		
		if(result.isPresent()) {
			
			employee = result.get();
			
		} else {
			
			throw new RuntimeException("Did not find employee Id of " + theId);
			
		}
		
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
	}

}