package com.flight.analist.ai;

import org.springframework.stereotype.Component;

import aima.core.search.framework.evalfunc.HeuristicFunction;

@Component
public class TimeHeuristicFuntion implements HeuristicFunction {
	
	public TimeHeuristicFuntion() {}
	
	@Override
	public double h(Object obj) {
		State state = (State) obj;
 		return state.getArrival();
	}

}
