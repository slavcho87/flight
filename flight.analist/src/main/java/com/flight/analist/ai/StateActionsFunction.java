package com.flight.analist.ai;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.flight.analist.itinerary.model.Itinerary;
import com.flight.analist.itinerary.service.ItineraryService;
import com.flight.analist.itinerary.service.ItineraryServiceImpl;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ActionsFunction;

public class StateActionsFunction implements ActionsFunction {
	
	private ItineraryService itineraryService = new ItineraryServiceImpl();

	@Override
	public Set<Action> actions(Object state) {
		Set<Action> actions = new LinkedHashSet<Action>();
			
		State city = (State) state;
		
		List<Itinerary> itineraries = itineraryService.getItinerary(city.getCity());
		for(Itinerary itinerary: itineraries) {
			if(city.getArrival() == null) {
				actions.add(new FlightAction(city.getCity(), itinerary.getFlightId()));
			}else {
				if(city.getArrival() < itinerary.getDeparture().getTime() ) {
					actions.add(new FlightAction(city.getCity(), itinerary.getFlightId()));
				}
			}
		}
		
		return actions;
	}

}
