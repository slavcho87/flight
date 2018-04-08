package com.flight.manager.city.exception;

public class CityNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CityNotFoundException() {}
	
	public CityNotFoundException(String message) {
		super(message);
	}
}
