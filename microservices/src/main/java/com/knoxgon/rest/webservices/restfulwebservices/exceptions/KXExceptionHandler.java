package com.knoxgon.rest.webservices.restfulwebservices.exceptions;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class KXExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(AccessDeniedException.class)
	public final ResponseEntity<Object> handleAccessExceptions(Exception ex, WebRequest req){
		return new ResponseEntity<Object>("Only authorized users are allowed", new HttpHeaders(), HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest req){
		return new ResponseEntity<Object>("Internal Error", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest req){
		return new ResponseEntity<Object>("User not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
