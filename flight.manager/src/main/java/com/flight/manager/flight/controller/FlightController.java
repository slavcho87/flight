package com.flight.manager.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flight.manager.city.exception.CityNotFoundException;
import com.flight.manager.flight.exception.FlightNotFound;
import com.flight.manager.flight.mapper.FlightMapper;
import com.flight.manager.flight.model.dto.FlightDTO;
import com.flight.manager.flight.model.dto.FlightList;
import com.flight.manager.flight.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private FlightMapper flightMapper;
	
	@RequestMapping(value = "/api/city/{cityName}/flight", method = RequestMethod.GET)
	public ResponseEntity<FlightList> findAll(@PathVariable("cityName") String cityName) throws CityNotFoundException{
		List<FlightDTO> flight = flightMapper.domainToDTO(flightService.findAllByDepartureCity(cityName));
		
		FlightList response = new FlightList();
		response.setItinerary(flight);
		
		return new ResponseEntity<FlightList>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/city/{cityName}/flight/{flightId}", method = RequestMethod.GET)
	public ResponseEntity<FlightDTO> findOne(@PathVariable("cityName") String cityName, @PathVariable("flightId") Integer flightId) throws CityNotFoundException, FlightNotFound{
		FlightDTO flightDTO = flightMapper.domainToDTO(flightService.findOne(cityName, flightId));
		return new ResponseEntity<FlightDTO>(flightDTO, HttpStatus.OK);
	}
	
}
