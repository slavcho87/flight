package com.flight.manager.city.service;

import org.springframework.data.domain.Page;

import com.flight.manager.city.exception.CityNotFoundException;
import com.flight.manager.city.model.City;

public interface CityService {
	
	public Iterable<City> findAll();
	public Page<City> findAll(Integer page, Integer pageSize);
	public City findOneByName(String name) throws CityNotFoundException;
	
}
