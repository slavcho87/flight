package com.flight.analist.itinerary.model.dto;

import java.io.Serializable;
import java.util.List;

public class ItineraryListDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<ItineraryDTO> itinerary;

	public List<ItineraryDTO> getItinerary() {
		return itinerary;
	}

	public void setItinerary(List<ItineraryDTO> itinerary) {
		this.itinerary = itinerary;
	}
	
}
