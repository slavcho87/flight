package com.flight.analist.itinerary.mapper;

import com.flight.analist.itinerary.model.Itinerary;
import com.flight.analist.itinerary.model.dto.ItineraryDTO;

public interface ItineraryMapper {

	public Itinerary dtoToDomain(ItineraryDTO itineraryDTO);
	
	public ItineraryDTO domainToDTO(Itinerary itineraryDTO);
	
}
