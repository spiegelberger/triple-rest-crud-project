package com.spiegelberger.triplerestcrudproject.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse>handleException(EmployeeNotFoundException exc) {
			
			EmployeeErrorResponse error = new EmployeeErrorResponse(
			exc.getMessage(),
			HttpStatus.NOT_FOUND,
			ZonedDateTime.now(ZoneId.of("Z"))
			);
			
			return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
			
		}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse>handleException(Exception exc) {
		
		EmployeeErrorResponse error = new EmployeeErrorResponse(
				exc.getMessage(),
				HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("Z"))
				);
			
		return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
		
	}
}
