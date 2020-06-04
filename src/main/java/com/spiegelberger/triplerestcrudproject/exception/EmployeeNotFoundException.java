package com.spiegelberger.triplerestcrudproject.exception;

public class EmployeeNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundException(String message) {
		super(message);
		
	}
}
