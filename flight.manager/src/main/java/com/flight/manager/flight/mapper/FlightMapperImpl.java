package com.flight.manager.flight.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.flight.manager.flight.model.Flight;
import com.flight.manager.flight.model.dto.FlightDTO;

@Component
public class FlightMapperImpl implements FlightMapper{

	@Override
	public List<FlightDTO> domainToDTO(List<Flight> flights) {
		List<FlightDTO> response = new ArrayList<FlightDTO>();
		
		Iterator<Flight> iterator = flights.iterator();
		
		while(iterator.hasNext()) {
			Flight flight = iterator.next();
			
			FlightDTO flightDTO = new FlightDTO();
			flightDTO.setFlightId(flight.getId());
			flightDTO.setDestination(flight.getArrivalCity().getName());
			flightDTO.setDeparture(flight.getDepartureTime().getTime());			
			flightDTO.setArrival(flight.getArrivalTime().getTime());
			
			response.add(flightDTO);
		}
		
		return response;
	}
	
	public FlightDTO domainToDTO(Flight flight) {
		FlightDTO flightDTO = new FlightDTO();
		flightDTO.setFlightId(flight.getId());
		flightDTO.setDestination(flight.getArrivalCity().getName());
		flightDTO.setDeparture(flight.getDepartureTime().getTime());			
		flightDTO.setArrival(flight.getArrivalTime().getTime());
		
		return flightDTO;
	}
}
