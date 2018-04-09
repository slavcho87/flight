package com.flight.analist.flight.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flight.analist.ai.StateActionsFunction;
import com.flight.analist.ai.StateGoalTest;
import com.flight.analist.ai.StateResultFunction;
import com.flight.analist.ai.FlightAction;
import com.flight.analist.ai.State;
import com.flight.analist.ai.TimeHeuristicFuntion;
import com.flight.analist.flight.exception.DestinationCityNotFound;
import com.flight.analist.flight.exception.OriginCityNotFound;
import com.flight.analist.flight.exception.OriginDestinationEqualsException;
import com.flight.analist.itinerary.model.Itinerary;
import com.flight.analist.itinerary.service.ItineraryService;
import com.flight.analist.utils.Constants;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.agent.Action;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private ItineraryService itineraryService;
	
	public List<Itinerary> getFastestWay(String originCity, String destinationCity) throws OriginCityNotFound, DestinationCityNotFound, OriginDestinationEqualsException, Exception {
		if(originCity == null || originCity.isEmpty()) {
			throw new OriginCityNotFound(Constants.ORIGIN_CITY_NAME_NOT_FOUND);
		}
		
		if(destinationCity == null || destinationCity.isEmpty()) {
			throw new DestinationCityNotFound(Constants.DESTINATION_CITY_NAME_NOT_FOUND);
		}
		
		if(originCity.equals(destinationCity)) {
			throw new OriginDestinationEqualsException(Constants.ORIGIN_DESTINATION_EQUALS_EXCEPTION);
		}
		
		State origin = new State();
		origin.setCity(originCity);
		
		State destination = new State();
		destination.setCity(destinationCity);	
		
		Problem problem = new Problem(origin, new StateActionsFunction(), new StateResultFunction(), new StateGoalTest(destination));
		SearchForActions search = new AStarSearch(new GraphSearch(), new TimeHeuristicFuntion());
		SearchAgent agent = new SearchAgent(problem, search);
		List<Action> actions = agent.getActions();
		
		List<Itinerary> itiniraries = new ArrayList<Itinerary>();
		for(Action action: actions) {
			FlightAction flightAction = (FlightAction) action;
			itiniraries.add(itineraryService.getById(flightAction.getCityName(), flightAction.getFlightId()));
		}
		
		return itiniraries;
	}
	
}
