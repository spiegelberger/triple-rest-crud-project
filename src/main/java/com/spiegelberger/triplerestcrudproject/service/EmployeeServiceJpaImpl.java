package com.spiegelberger.triplerestcrudproject.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spiegelberger.triplerestcrudproject.dao.EmployeeDAO;
import com.spiegelberger.triplerestcrudproject.entity.Employee;
import com.spiegelberger.triplerestcrudproject.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceJpaImpl implements EmployeeService {
	
	private EmployeeDAO employeeDao;

	@Autowired
	public EmployeeServiceJpaImpl(@Qualifier("employeeDAOJpa")  EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	
	@Override
	@Transactional
	public List<Employee> findAll() {
	
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		 Optional<Employee>result = Optional.ofNullable(employeeDao.findById(theId));
		 Employee theEmployee = result.orElseThrow(()->
		  new EmployeeNotFoundException("Employee id not found: " + theId));
		
		 return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
		
	}

}
