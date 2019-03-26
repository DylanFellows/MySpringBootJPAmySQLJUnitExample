package com.tek.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing

@SpringBootApplication
public class VehicleApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(VehicleApplication.class, args);
	}

}
