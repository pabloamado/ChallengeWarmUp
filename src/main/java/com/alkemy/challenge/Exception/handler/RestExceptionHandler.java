package com.alkemy.challenge.Exception.handler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.alkemy.challenge.Exception.BodyDtoException;
import com.alkemy.challenge.Exception.UserException;
import com.alkemy.challenge.Exception.error.CustomError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e, WebRequest webRequest) {

		CustomError error = new CustomError(HttpStatus.NOT_FOUND, e.getMessage());

		return new ResponseEntity<>(error, error.getStatus());

	}

	@ExceptionHandler(value = BodyDtoException.class)
	protected ResponseEntity<Object> handleBodyDtoException(BodyDtoException e, WebRequest webRequest) {

		CustomError error = new CustomError(HttpStatus.BAD_REQUEST, e.getMessage());

		return new ResponseEntity<>(error, error.getStatus());

	}

	@ExceptionHandler(value = BadCredentialsException.class)
	protected ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException e, WebRequest webRequest) {

		CustomError error = new CustomError(HttpStatus.FORBIDDEN, e.getMessage());

		return new ResponseEntity<>(error, error.getStatus());

	}

	@ExceptionHandler(value = UsernameNotFoundException.class)
	protected ResponseEntity<Object> handleBadCredentialsException(UsernameNotFoundException e, WebRequest webRequest) {

		CustomError error = new CustomError(HttpStatus.NOT_FOUND, e.getMessage());

		return new ResponseEntity<>(error, error.getStatus());

	}

	@ExceptionHandler(value = UserException.class)
	protected ResponseEntity<Object> handleBadCredentialsException(UserException e, WebRequest webRequest) {

		CustomError error = new CustomError(HttpStatus.FORBIDDEN, e.getMessage());

		return new ResponseEntity<>(error, error.getStatus());

	}

	@ExceptionHandler(value = { SQLIntegrityConstraintViolationException.class, DataIntegrityViolationException.class,
			ConstraintViolationException.class })
	protected ResponseEntity<Object> throwConstrainViolationException(ConstraintViolationException e, WebRequest webRequest) {

		CustomError error = new CustomError(HttpStatus.BAD_REQUEST, e.getMessage());

		return new ResponseEntity<>(error,error.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
			HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
		List<String> errors = new ArrayList<>();
		for (FieldError error : e.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : e.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		return handleExceptionInternal(e, errors, headers, HttpStatus.BAD_REQUEST, webRequest);
	}

}
