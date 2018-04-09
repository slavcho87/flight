package com.flight.analist.flight.service;

import java.util.List;

import com.flight.analist.flight.exception.DestinationCityNotFound;
import com.flight.analist.flight.exception.OriginCityNotFound;
import com.flight.analist.flight.exception.OriginDestinationEqualsException;
import com.flight.analist.itinerary.model.Itinerary;

public interface FlightService {

	public List<Itinerary> getFastestWay(String origin, String destination) throws OriginCityNotFound, DestinationCityNotFound, OriginDestinationEqualsException, Exception;
	
}
