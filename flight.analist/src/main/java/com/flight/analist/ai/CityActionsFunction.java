package com.flight.analist.ai;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.flight.analist.city.model.City;
import com.flight.analist.itinerary.model.Itinerary;
import com.flight.analist.itinerary.service.ItineraryService;
import com.flight.analist.itinerary.service.ItineraryServiceImpl;
import aima.core.agent.Action;
import aima.core.search.framework.problem.ActionsFunction;

public class CityActionsFunction implements ActionsFunction {
	
	private ItineraryService itineraryService = new ItineraryServiceImpl();

	@Override
	public Set<Action> actions(Object state) {
		Set<Action> actions = new LinkedHashSet<Action>();
			
		City city = (City) state;
		
		List<Itinerary> itineraries = itineraryService.getItinerary(city.getName());
		for(Itinerary itinerary: itineraries) {
			actions.add(new FlightAction(city.getName(), itinerary.getFlightId()));
		}
		
		return actions;
	}

}
