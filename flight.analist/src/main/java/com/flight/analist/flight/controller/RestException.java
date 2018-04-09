package com.flight.analist.flight.controller;

import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.flight.analist.exception.ApiException;
import com.flight.analist.flight.exception.DestinationCityNotFound;
import com.flight.analist.flight.exception.OriginCityNotFound;
import com.flight.analist.flight.exception.OriginDestinationEqualsException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(OriginCityNotFound.class)
	protected ResponseEntity<ApiException> originCityNotFoundException(OriginCityNotFound ex){
		ApiException apiError = new ApiException();
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setTimestamp(new Date().getTime());
		apiError.setMessage(ex.getMessage());
		
		return new ResponseEntity<ApiException>(apiError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DestinationCityNotFound.class)
	protected ResponseEntity<ApiException> destinationCityNotFoundException(DestinationCityNotFound ex){
		ApiException apiError = new ApiException();
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setTimestamp(new Date().getTime());
		apiError.setMessage(ex.getMessage());
		
		return new ResponseEntity<ApiException>(apiError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OriginDestinationEqualsException.class)
	protected ResponseEntity<ApiException> originDestinationEqualsException(OriginDestinationEqualsException ex){
		ApiException apiError = new ApiException();
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setTimestamp(new Date().getTime());
		apiError.setMessage(ex.getMessage());
		
		return new ResponseEntity<ApiException>(apiError, HttpStatus.BAD_REQUEST);
	}
	
}
