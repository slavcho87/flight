package com.flight.manager.flight.controller;

import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.flight.manager.city.exception.CityNotFoundException;
import com.flight.manager.exception.ApiException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CityNotFoundException.class)
	protected ResponseEntity<ApiException> cityNotFoundException(CityNotFoundException ex){
		ApiException apiError = new ApiException();
		apiError.setStatus(HttpStatus.NOT_FOUND);
		apiError.setTimestamp(new Date().getTime());
		apiError.setMessage(ex.getMessage());
		
		return new ResponseEntity<ApiException>(apiError, HttpStatus.NOT_FOUND);
	}
	
}
