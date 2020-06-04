package com.spiegelberger.triplerestcrudproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiegelberger.triplerestcrudproject.dao.EmployeeRepository;
import com.spiegelberger.triplerestcrudproject.entity.Employee;
import com.spiegelberger.triplerestcrudproject.exception.EmployeeNotFoundException;

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
		
		 Optional<Employee>result = employeeRepository.findById(theId);
		 Employee theEmployee = result.orElseThrow(()->
		 		new EmployeeNotFoundException("Employee id not found: " + theId));
		
		 return theEmployee;
	}
	
	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
	}

}
