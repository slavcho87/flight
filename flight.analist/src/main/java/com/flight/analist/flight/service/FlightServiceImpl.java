package com.flight.analist.flight.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.analist.ai.CityActionsFunction;
import com.flight.analist.ai.CityGoalTest;
import com.flight.analist.ai.CityResultFunction;
import com.flight.analist.ai.TimeHeuristicFuntion;
import com.flight.analist.city.model.City;
import com.flight.analist.itinerary.service.ItineraryService;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.agent.Action;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private ItineraryService itineraryService;

	public void getFastestWay(String originCity, String destinationCity) throws Exception {
		City origin = new City();
		origin.setName(originCity);
		origin.setItineraries(itineraryService.getItinerary(originCity));
		
		City destination = new City();
		destination.setName(destinationCity);	
		
		Problem problem = new Problem(destination, new CityActionsFunction(), new CityResultFunction(), new CityGoalTest(origin));
		SearchForActions search = new GreedyBestFirstSearch(new GraphSearch(), new TimeHeuristicFuntion(origin));
		SearchAgent agent = new SearchAgent(problem, search);
		List<Action> actions = agent.getActions();
		System.out.println(actions);
	}

	public void getSortestWay(String originCity, String destinationCity) {
		
	}
	
}
