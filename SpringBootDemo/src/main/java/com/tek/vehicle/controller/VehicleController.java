package com.tek.vehicle.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tek.vehicle.exception.ResourceNotFoundException;
import com.tek.vehicle.model.Vehicle;
import com.tek.vehicle.repository.VehicleRepository;

@RestController
@RequestMapping("/api/tek")
public class VehicleController {

	@Autowired
	VehicleRepository vehicleRepository;

	// Get All vehicles
	@GetMapping("/vehicles")
	public List<Vehicle> getAllvehicles() {
		return vehicleRepository.findAll();
	}

	// Create a new vehicle
	@PostMapping("/vehicle")
	public Vehicle createvehicle(@Valid @RequestBody Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	// Get a Single vehicle
	@GetMapping("/vehicle/{id}")
	public Vehicle getvehicleById(@PathVariable(value = "id") Long vehicleId) {

		return vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle", "id", vehicleId));
	}

	// Update a vehicle
	@PutMapping("/vehicle/{id}")
	public Vehicle updatevehicle(@PathVariable(value = "id") Long vehicleId,
			@Valid @RequestBody Vehicle vehicleDetails) {

		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle", "id", vehicleId));

		vehicle.setVin(vehicleDetails.getVin());
		vehicle.setYear(vehicleDetails.getYear());
		vehicle.setMake(vehicleDetails.getMake());
		vehicle.setModel(vehicleDetails.getModel());
		vehicle.setColor(vehicleDetails.getColor());
		vehicle.setMileage(vehicleDetails.getMileage());

		Vehicle updatedvehicle = vehicleRepository.save(vehicle);
		return updatedvehicle;
	}

	// Delete a vehicle
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<?> deletevehicle(@PathVariable(value = "id") Long vehicleId) {

		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle", "id", vehicleId));

		vehicleRepository.delete(vehicle);

		return ResponseEntity.ok().build();
	}
}
