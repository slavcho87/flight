package com.flight.analist.ai;

public class State {

	private String city;
	
	private Long arrival;
	
	private Integer flightId;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
