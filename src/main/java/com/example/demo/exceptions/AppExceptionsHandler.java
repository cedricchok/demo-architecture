package com.example.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.models.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler {
	// Custom error message in api callback for user
	@ExceptionHandler(value = { UserServiceException.class })
	public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest req) {

		ErrorMessage err = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Custom error message in api callback
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleOtherException(Exception ex, WebRequest req) {

		ErrorMessage err = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
