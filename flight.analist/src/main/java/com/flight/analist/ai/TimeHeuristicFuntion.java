package com.flight.analist.ai;

import com.flight.analist.city.model.City;

import aima.core.search.framework.evalfunc.HeuristicFunction;

public class TimeHeuristicFuntion implements HeuristicFunction {

	private City origin;
	
	public TimeHeuristicFuntion(City origin) {
		this.origin = origin;
	}
	
	@Override
	public double h(Object state) {
		return 0;
	}

}
