package com.flight.manager.flight.mapper;

import java.util.List;

import com.flight.manager.flight.model.Flight;
import com.flight.manager.flight.model.dto.FlightDTO;

public interface FlightMapper {

	public List<FlightDTO> domainToDTO(List<Flight> flights);
	
}
