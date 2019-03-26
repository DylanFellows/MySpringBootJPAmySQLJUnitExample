package com.tek.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// THIS ANNOTATION MUST BE PRESENT TO ALLOW THE CREATED AT AND LAST UPDATED
// DATE TO BE AUTOMATICALLY POPULATED.
@EnableJpaAuditing

// LETS US KNOW THAT THIS IS THE CLASS THAT STARTS UP THE SPRING BOOT APP
@SpringBootApplication
public class VehicleApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(VehicleApplication.class, args);
	}

}
