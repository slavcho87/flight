package com.flight.manager.flight.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.flight.manager.flight.model.Flight;

public interface FlightRepository extends PagingAndSortingRepository<Flight, Integer> {
	
	
	public List<Flight> findByDepartureCityId(Integer id);
	
}
