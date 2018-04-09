package com.flight.analist.flight.exception;

public class DestinationCityNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DestinationCityNotFound() {}
	
	public DestinationCityNotFound(String message) {
		super(message);
	}

}
