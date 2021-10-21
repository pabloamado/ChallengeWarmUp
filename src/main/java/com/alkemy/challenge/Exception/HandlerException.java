package com.alkemy.challenge.Exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value=EntityNotFoundException.class)
	protected ResponseEntity<Object> throwEntityNotFoundException(RuntimeException e, WebRequest webRequest){
		
		String message= e.getMessage();
		
		return handleExceptionInternal(e, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}
	
}
