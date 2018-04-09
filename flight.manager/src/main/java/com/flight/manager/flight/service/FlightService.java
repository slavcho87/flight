package com.flight.manager.flight.service;

import java.util.List;

import com.flight.manager.city.exception.CityNotFoundException;
import com.flight.manager.flight.exception.FlightNotFound;
import com.flight.manager.flight.model.Flight;

public interface FlightService {

	public List<Flight> findAllByDepartureCity(String departureCity)  throws CityNotFoundException;
	public Flight findOne(String cityName, Integer id)  throws CityNotFoundException, FlightNotFound;
	
}
