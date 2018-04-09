package com.flight.analist.itinerary.service;

import java.util.List;

import com.flight.analist.itinerary.model.Itinerary;

public interface ItineraryService {

	public List<Itinerary> getItinerary(String city);
	public Itinerary getById(String cityName, Integer id);
	
}
