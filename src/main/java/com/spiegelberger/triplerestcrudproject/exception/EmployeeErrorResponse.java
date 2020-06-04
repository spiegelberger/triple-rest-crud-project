package com.spiegelberger.triplerestcrudproject.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;



public class EmployeeErrorResponse {
	private final String message;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timeStamp;

	public EmployeeErrorResponse(String message, HttpStatus httpStatus, ZonedDateTime timeStamp ) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
	}

	public HttpStatus  getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}

}
