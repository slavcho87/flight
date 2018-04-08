package com.flight.manager.city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.flight.manager.city.exception.CityNotFoundException;
import com.flight.manager.city.model.City;
import com.flight.manager.city.repository.CityRepository;
import com.flight.manager.utils.Constants;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public Page<City> findAll(Integer page, Integer pageSize){
		return cityRepository.findAll(new PageRequest(page - 1 , pageSize, Direction.ASC, "id", "name"));
	}
	
	public Iterable<City> findAll(){
		return cityRepository.findAll(new Sort(Direction.ASC, "id", "name"));
	}
	
	public City findOneByName(String name) throws CityNotFoundException {
		City city = cityRepository.findOneByName(name);
	
		if(city == null) {
			throw new CityNotFoundException(Constants.CITY_NAME_NOT_FOUND);
		}
		
		return city;
	}
}
