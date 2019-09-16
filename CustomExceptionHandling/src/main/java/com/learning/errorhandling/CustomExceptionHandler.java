package com.learning.errorhandling;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{


	/*
	 * EmployeeNotFoundException
	 */
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<CustomExceptionResponse> handleUserNotFoundException(Exception ex, WebRequest request) 
			{
		CustomExceptionResponse response =
				new CustomExceptionResponse(new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<CustomExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	/*
	 * Generic Exception
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CustomExceptionResponse> handleAnyException(Exception ex, WebRequest request) 
			{
		CustomExceptionResponse response =
				new CustomExceptionResponse(new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<CustomExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
