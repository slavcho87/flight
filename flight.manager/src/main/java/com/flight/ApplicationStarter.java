package com.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApplicationStarter {
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStarter.class, args);
	}
}
