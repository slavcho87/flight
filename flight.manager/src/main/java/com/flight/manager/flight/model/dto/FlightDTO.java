package com.flight.manager.flight.model.dto;

public class FlightDTO {
	
	private Integer flightId;
	
	private String destination;
	
	private Long departure;
	
	private Long arrival;

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

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	
}
