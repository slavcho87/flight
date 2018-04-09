package com.flight.analist.flight.service;

public interface FlightService {

	public void getFastestWay(String origin, String destination) throws Exception;
	public void getSortestWay(String originCity, String destinationCity);
	
}
