package com.flight.manager.flight.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.flight.manager.city.model.City;

@Entity
public class Flight {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private Date departureTime;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="departure_city")
	private City departureCity;
	
	private Date arrivalTime;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="arrival_city")
	private City arrivalCity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public City getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(City departureCity) {
		this.departureCity = departureCity;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public City getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
}

