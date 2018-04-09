package com.flight.analist.ai;

import com.flight.analist.itinerary.model.Itinerary;
import com.flight.analist.itinerary.service.ItineraryService;
import com.flight.analist.itinerary.service.ItineraryServiceImpl;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ResultFunction;

public class StateResultFunction implements ResultFunction {

	private ItineraryService itineraryService = new ItineraryServiceImpl();
	
	@Override
	public Object result(Object s, Action a) {
		FlightAction action = (FlightAction) a;
		
		Itinerary itinerary = itineraryService.getById(action.getCityName(), action.getFlightId());
		
		State state = new State();
		state.setCity(itinerary.getDestination());
		state.setArrival(itinerary.getArrival().getTime());
		state.setFlightId(itinerary.getFlightId());
				
		return state;
	}

}
