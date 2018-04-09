package com.flight.analist.itinerary.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flight.analist.itinerary.model.Itinerary;
import com.flight.analist.itinerary.model.dto.ItineraryDTO;
import com.flight.analist.itinerary.model.dto.ItineraryListDTO;

@Service
public class ItineraryServiceImpl implements ItineraryService {

	@Override
	public List<Itinerary> getItinerary(String cityName) {
		String uri = "http://localhost:8091/api/city/"+cityName+"/flight";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ItineraryListDTO> response = restTemplate.getForEntity(uri, ItineraryListDTO.class);
		
		List<Itinerary> itineraries = new ArrayList<Itinerary>();
		
		for(ItineraryDTO itineraryDTO: response.getBody().getItinerary()) {
			Itinerary itinerary = new Itinerary();
			itinerary.setFlightId(itineraryDTO.getFlightId());
			itinerary.setDestination(itineraryDTO.getDestination());
			itinerary.setDeparture(new Date(itineraryDTO.getDeparture()));
			itinerary.setArrival(new Date(itineraryDTO.getArrival()));
			
			itineraries.add(itinerary);
		}

		return itineraries;
	}

	@Override
	public Itinerary getById(String cityName, Integer id) {
		String uri = "http://localhost:8091/api/city/"+cityName+"/flight/"+id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ItineraryDTO> response = restTemplate.getForEntity(uri, ItineraryDTO.class);
				
		Itinerary itinerary = new Itinerary();
		itinerary.setFlightId(response.getBody().getFlightId());
		itinerary.setDestination(response.getBody().getDestination());
		itinerary.setDeparture(new Date(response.getBody().getDeparture()));
		itinerary.setArrival(new Date(response.getBody().getArrival()));
		
		return itinerary;
	}

}
