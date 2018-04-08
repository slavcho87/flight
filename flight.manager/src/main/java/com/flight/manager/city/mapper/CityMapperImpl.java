package com.flight.manager.city.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.flight.manager.city.model.City;
import com.flight.manager.city.model.dto.CityDTO;

@Component
public class CityMapperImpl implements CityMapper {

	public List<CityDTO> domainToDTO(Iterable<City> cities){
		List<CityDTO> result = new ArrayList<CityDTO>();
		
		Iterator<City> iterator = cities.iterator();
		while(iterator.hasNext()) {
			City city = iterator.next();
			CityDTO cityDTO = new CityDTO();
			cityDTO.setCityId(city.getId());
			cityDTO.setCityName(city.getName());
			
			result.add(cityDTO);
		}
		
		return result;
	}
	
}
