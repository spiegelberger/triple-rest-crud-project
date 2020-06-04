package com.spiegelberger.triplerestcrudproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiegelberger.triplerestcrudproject.entity.Employee;
import com.spiegelberger.triplerestcrudproject.exception.EmployeeNotFoundException;
import com.spiegelberger.triplerestcrudproject.service.EmployeeService;

@RestController
@RequestMapping("/hibernate")
public class EmployeeControllerHibernate {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeControllerHibernate(@Qualifier("employeeServiceHibernateImpl") EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@GetMapping("/employees")
	public List<Employee>findAll(){
		return employeeService.findAll();
		
	}
	
	@GetMapping("/employees/{theId}")
	public Employee findById(@PathVariable int theId) {
		Employee theEmployee = employeeService.findById(theId);
		if (theEmployee == null) {
			throw new EmployeeNotFoundException("Employee id not found: "+ theId);
		} 
		return theEmployee;
		
	}
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee theEmployee){
		theEmployee.setId(0);
		 employeeService.save(theEmployee);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("employees/{theId}")
	public String deleteEmployee(@PathVariable int theId) {
		
		Employee theEmployee = employeeService.findById(theId);
		if(theEmployee == null) {
			throw new EmployeeNotFoundException("Employee id not found: " + theId);
		}
		employeeService.deleteById(theId);
		return "Employee is deleted: " + theId;
	}
	
	
	
	
}
