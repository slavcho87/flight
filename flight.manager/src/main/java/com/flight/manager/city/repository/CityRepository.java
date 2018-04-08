package com.flight.manager.city.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.flight.manager.city.model.City;

public interface CityRepository extends PagingAndSortingRepository<City, Integer> {

	public City findOneByName(String name);
	
}
