package com.flight.analist.itinerary.mapper;

import java.util.Date;
import org.springframework.stereotype.Component;
import com.flight.analist.itinerary.model.Itinerary;
import com.flight.analist.itinerary.model.dto.ItineraryDTO;

@Component
public class ItineraryMapperImpl implements ItineraryMapper {

	@Override
	public Itinerary dtoToDomain(ItineraryDTO itineraryDTO) {
		Itinerary itinerary = new Itinerary();
		itinerary.setFlightId(itineraryDTO.getFlightId());
		itinerary.setDestination(itineraryDTO.getDestination());
		itinerary.setDeparture(new Date(itineraryDTO.getDeparture()));
		itinerary.setArrival(new Date(itineraryDTO.getArrival()));
		
		return itinerary;
	}

	@Override
	public ItineraryDTO domainToDTO(Itinerary itinerary) {
		ItineraryDTO itineraryDTO = new ItineraryDTO();
		itineraryDTO.setFlightId(itinerary.getFlightId());
		itineraryDTO.setDestination(itinerary.getDestination());
		itineraryDTO.setDeparture(itinerary.getDeparture().getTime());
		itineraryDTO.setArrival(itinerary.getArrival().getTime());
		
		return itineraryDTO;
	}

}
