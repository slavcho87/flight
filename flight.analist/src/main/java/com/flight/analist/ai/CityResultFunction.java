package com.flight.analist.ai;

import com.flight.analist.city.model.City;
import com.flight.analist.itinerary.model.Itinerary;
import com.flight.analist.itinerary.service.ItineraryService;
import com.flight.analist.itinerary.service.ItineraryServiceImpl;
import aima.core.agent.Action;
import aima.core.search.framework.problem.ResultFunction;

public class CityResultFunction implements ResultFunction {

	private ItineraryService itineraryService = new ItineraryServiceImpl();
	
	@Override
	public Object result(Object s, Action a) {
		FlightAction action = (FlightAction) a;
		
		Itinerary itinerary = itineraryService.getById(action.getCityName(), action.getFlightId());
		
		City city = new City();
		city.setName(itinerary.getDestination());
		
		return city;
	}

}
