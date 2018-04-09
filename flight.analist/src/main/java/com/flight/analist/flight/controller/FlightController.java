package com.flight.analist.flight.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.flight.analist.flight.exception.DestinationCityNotFound;
import com.flight.analist.flight.exception.OriginCityNotFound;
import com.flight.analist.flight.exception.OriginDestinationEqualsException;
import com.flight.analist.flight.service.FlightService;
import com.flight.analist.itinerary.mapper.ItineraryMapper;
import com.flight.analist.itinerary.model.Itinerary;
import com.flight.analist.itinerary.model.dto.ItineraryDTO;
import com.flight.analist.itinerary.model.dto.ItineraryListDTO;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private ItineraryMapper mapper;
	
	@RequestMapping(value = "/api/flight", params = {"action=fastestWay"}, method = RequestMethod.GET)
	public ResponseEntity<ItineraryListDTO> getFastestWay(@RequestParam (value = "origin", required = true) String origin, @RequestParam(value = "destination", required = true) String destination) throws OriginCityNotFound, DestinationCityNotFound, OriginDestinationEqualsException, Exception {		
		List<Itinerary> itineraries = flightService.getFastestWay(origin, destination);

		List<ItineraryDTO> itinerariesDTO = new ArrayList<ItineraryDTO>();
		for(Itinerary itinerary: itineraries) {
			itinerariesDTO.add(mapper.domainToDTO(itinerary));
		}
		
		ItineraryListDTO response = new ItineraryListDTO();
		response.setItinerary(itinerariesDTO);
		
		return new ResponseEntity<ItineraryListDTO>(response, HttpStatus.OK);
	}
	
}