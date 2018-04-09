package com.flight.analist.city.model;

import java.util.List;
import com.flight.analist.itinerary.model.Itinerary;

public class City {

	private String name;
	
	private List<Itinerary> itineraries;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}
	
}
