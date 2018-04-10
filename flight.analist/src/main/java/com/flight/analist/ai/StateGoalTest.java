package com.flight.analist.ai;

import org.springframework.stereotype.Component;

import aima.core.search.framework.problem.GoalTest;

@Component
public class StateGoalTest implements GoalTest {

	private State destination;
	
	public StateGoalTest(State destination) {
		this.destination= destination;
	}
	
	@Override
	public boolean isGoalState(Object obj) {
		State state = (State) obj;
		return destination.getCity().equals(state.getCity());
	}

}
