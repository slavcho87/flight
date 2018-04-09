package com.flight.analist.flight.exception;

public class OriginCityNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OriginCityNotFound() {}
	
	public OriginCityNotFound(String message) {
		super(message);
	}

}
