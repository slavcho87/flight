package com.flight.analist.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.flight.analist.flight.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value = "/api/flight", params = {"action=fastestWay"}, method = RequestMethod.GET)
	public String getFastestWay(@RequestParam ("origin") String origin, @RequestParam("destination") String destination) throws Exception {		
		flightService.getFastestWay(origin, destination);
		
		return "getFastestWay()";
	}
	
	@RequestMapping(value = "/api/flight", params = {"action=sortestWay"}, method = RequestMethod.GET)
	public String getSortestWay(@RequestParam ("origin") String origin, @RequestParam("destination") String destination) {
		flightService.getSortestWay(origin, destination);
		
		return "getSortestWay()";
	}
	
}