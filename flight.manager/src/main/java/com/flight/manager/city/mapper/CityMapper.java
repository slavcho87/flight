package com.flight.manager.city.mapper;

import java.util.List;

import com.flight.manager.city.model.City;
import com.flight.manager.city.model.dto.CityDTO;

public interface CityMapper {
	public List<CityDTO> domainToDTO(Iterable<City> cities);
}
