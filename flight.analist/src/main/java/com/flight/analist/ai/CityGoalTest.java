package com.flight.analist.ai;

import com.flight.analist.city.model.City;

import aima.core.search.framework.problem.GoalTest;

public class CityGoalTest implements GoalTest {

	private City origin;
	
	public CityGoalTest(City origin) {
		this.origin = origin;
	}
	
	@Override
	public boolean isGoalState(Object state) {
		City destination = (City) state;
	
		return origin.getName().equals(destination.getName());
	}

}
