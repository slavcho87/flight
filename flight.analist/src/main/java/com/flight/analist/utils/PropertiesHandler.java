package com.flight.analist.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesHandler {

	@Value("${flight.manager.baseUri}")
	private String flightManagerBaseUri;
	
	@Value("${flight.manager.api}")
	private String flightManagerApi;
	
	@Value("${flight.manager.city}")
	private String flightManagerCity;
	
	@Value("${flight.manager.flight}")
	private String flightManagerFlight;

	public String getFlightManagerBaseUri() {
		return flightManagerBaseUri;
	}

	public String getFlightManagerApi() {
		return flightManagerApi;
	}

	public String getFlightManagerCity() {
		return flightManagerCity;
	}

	public String getFlightManagerFlight() {
		return flightManagerFlight;
	}
	
}
