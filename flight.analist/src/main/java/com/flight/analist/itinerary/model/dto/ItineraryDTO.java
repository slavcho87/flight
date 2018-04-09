package com.flight.analist.itinerary.model.dto;

import java.io.Serializable;

public class ItineraryDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer flightId;
	
	private String destination;
	
	private Long departure;
	
	private Long arrival;

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getDeparture() {
		return departure;
	}

	public void setDeparture(Long departure) {
		this.departure = departure;
	}

	public Long getArrival() {
		return arrival;
	}

	public void setArrival(Long arrival) {
		this.arrival = arrival;
	}
	
}
