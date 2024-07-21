package com.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This class is to provide specific format for Without this class we will get
 * all unwanted data in the exception of the postman response Using this class
 * we can give only required set of information
 * 
 * 
 * Whatever the classes you are trying to handle exceptions that has to given
 * with @ControlerAdvice
 */

@ControllerAdvice
@ResponseStatus
public class DepartmentExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> departmentNotFoundException(
			DepartmentNotFoundException departmentNotFoundException, WebRequest request) {
		var errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, departmentNotFoundException.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

	}

}
