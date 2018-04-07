package com.flight.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesHandler {

	@Value("${user}")
    private String user;

	public String getUser() {
		return user;
	}
	
	
	
}
