package com.flight.analist.ai;

import aima.core.agent.Action;
import aima.core.agent.impl.ObjectWithDynamicAttributes;

public class FlightAction extends ObjectWithDynamicAttributes implements Action{

	public static final String ATTRIBUTE_FLIGHT_ID = "flightId";
	public static final String ATTRIBUTE_CITY_NAME = "cityName";

	public FlightAction(String cityName, Integer flightId) {
		this.setAttribute(ATTRIBUTE_FLIGHT_ID, flightId);
		this.setAttribute(ATTRIBUTE_CITY_NAME, cityName);
	}
	
	@Override
	public boolean isNoOp() {
		return false;
	}

	public Integer getFlightId() {
		return (Integer) getAttribute(ATTRIBUTE_FLIGHT_ID);
	}
	
	public String getCityName() {
		return (String) getAttribute(ATTRIBUTE_CITY_NAME);
	}
	
	@Override
	public String describeType() {
		return Action.class.getSimpleName();
	}
	
}
