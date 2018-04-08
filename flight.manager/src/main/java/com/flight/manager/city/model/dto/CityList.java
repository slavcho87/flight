package com.flight.manager.city.model.dto;

import java.util.List;

public class CityList {

	private List<CityDTO> data;
	
	private Integer count;

	public List<CityDTO> getData() {
		return data;
	}

	public void setData(List<CityDTO> data) {
		this.data = data;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
