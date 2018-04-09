package com.flight.manager.flight.exception;

public class FlightNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public FlightNotFound() {}
	
	public FlightNotFound(String message) {
		super(message);
	}
	
}
