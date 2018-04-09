package com.flight.analist.ai;

import aima.core.search.framework.evalfunc.HeuristicFunction;

public class TimeHeuristicFuntion implements HeuristicFunction {
	
	public TimeHeuristicFuntion() {}
	
	@Override
	public double h(Object obj) {
		State state = (State) obj;
 		return state.getArrival();
	}

}
