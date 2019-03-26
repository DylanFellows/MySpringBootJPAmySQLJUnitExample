package com.tek.vehicle.test.controller;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tek.vehicle.model.Vehicle;
import com.tek.vehicle.repository.VehicleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VehicleControllerTest.class)
public class VehicleControllerTest {

	final static String host = "http://localhost:8080";
	final static String path = "/api/tek/vehicle/";

	@MockBean
	private Vehicle vehicle;

	@MockBean
	private VehicleRepository vehicleRepository;

	@Test
	public void invalidVehicleId() {
		given().when().get(path + "abc").then().statusCode(400);
	}

	@Test
	public void addVehicle() {
		Map<String, String> vehicle = new HashMap<>();
		vehicle.put("vin", "1AQ54728");
		vehicle.put("year", "2019");
		vehicle.put("make", "Ford");
		vehicle.put("model", "Mustang");
		vehicle.put("color", "Blue");
		vehicle.put("mileage", "1100");
		given().contentType("application/json").body(vehicle).when().post(path).then().statusCode(200);
	}

	@Test
	public void addVehicleWithInvalidJson() {
		Map<String, String> vehicle = new HashMap<>();
		vehicle.put("vin", "1AQ54728");
		given().contentType("application/json").body(vehicle).when().post(path).then().statusCode(400);
	}

	@Test
	public void deleteVehicle() {
		given().when().delete(path + "1").then().statusCode(200);
	}

}
