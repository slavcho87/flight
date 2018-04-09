package com.flight.manager.flight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.manager.city.exception.CityNotFoundException;
import com.flight.manager.city.model.City;
import com.flight.manager.city.service.CityService;
import com.flight.manager.flight.exception.FlightNotFound;
import com.flight.manager.flight.model.Flight;
import com.flight.manager.flight.repository.FlightRepository;
import com.flight.manager.utils.Constants;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private CityService cityService;
	
	public List<Flight> findAllByDepartureCity(String departureCity) throws CityNotFoundException {
		City city = cityService.findOneByName(departureCity);
		List<Flight> flights = flightRepository.findByDepartureCityId(city.getId());
		
		if(flights == null || flights.isEmpty()) {
			return new ArrayList<Flight>();
		}
		
		return flights;
	}
	
	public Flight findOne(String cityName, Integer id) throws CityNotFoundException, FlightNotFound {
		City city = cityService.findOneByName(cityName);
		Flight flight = flightRepository.findByIdAndDepartureCityId(id, city.getId());
		
		if(flight == null) {
			throw new FlightNotFound(Constants.FLIGHT_ID_NOT_FOUND);
		}
		
		return flight;		
	}
	
}
