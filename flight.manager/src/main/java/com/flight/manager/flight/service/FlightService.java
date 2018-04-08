package com.flight.manager.flight.service;

import java.util.List;

import com.flight.manager.city.exception.CityNotFoundException;
import com.flight.manager.flight.model.Flight;

public interface FlightService {

	public List<Flight> findAllByDepartureCity(String departureCity)  throws CityNotFoundException;
	
}
