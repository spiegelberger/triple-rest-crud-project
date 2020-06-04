package com.spiegelberger.triplerestcrudproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spiegelberger.triplerestcrudproject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
