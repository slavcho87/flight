package com.flight.manager.city.controller;

import static java.lang.Math.toIntExact;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.manager.city.mapper.CityMapper;
import com.flight.manager.city.model.City;
import com.flight.manager.city.model.dto.CityDTO;
import com.flight.manager.city.model.dto.CityList;
import com.flight.manager.city.service.CityService;

@RestController
public class CityController {

	@Autowired
	private CityService cityService;
	
	@Autowired
	private CityMapper cityMapper;
	
	@RequestMapping(value = "/api/city", method = RequestMethod.GET)
	public ResponseEntity<CityList> findAll() {
		List<CityDTO> cities = cityMapper.domainToDTO(cityService.findAll());
		
		CityList response = new CityList();
		response.setData(cities);
		response.setCount(cities.size());
		
		return new ResponseEntity<CityList>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/city", params= {"page", "pageSize"}, method = RequestMethod.GET)
	public ResponseEntity<CityList> findAll( @RequestParam(value = "page") Integer page,  @RequestParam(value = "pageSize") Integer pageSize) {
		Page<City> cityPage = cityService.findAll(page, pageSize);
		List<CityDTO> cities = cityMapper.domainToDTO(cityPage.getContent());
		
		CityList response = new CityList();
		response.setData(cities);
		response.setCount(toIntExact(cityPage.getTotalElements()));
		
		return new ResponseEntity<CityList>(response, HttpStatus.OK);
	}
	
}
