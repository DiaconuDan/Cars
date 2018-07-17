package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Car;
import com.example.services.CarService;

@RestController
@RequestMapping("/v1/cars")
public class CarsController {
	@Autowired
	private CarService carService;
	
	@GetMapping
	public ResponseEntity<List<Car>>getAll() {
		List<Car> cars = this.carService.findAll();
		
		if ( cars.isEmpty()) {
			return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Car> create(@RequestBody Car car) {
		Car newCar = carService.create(car);
		return new ResponseEntity<Car>(newCar, HttpStatus.CREATED);
	}
	
	@GetMapping(path= {"/{id}"})
	public ResponseEntity <Car> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<Car>(carService.getById(id), HttpStatus.OK);
	}
	
	@DeleteMapping(path= {"/{id}"})
	public ResponseEntity<Car> delete(@PathVariable("id") Long id) {
		return new ResponseEntity <Car> (carService.delete(id), HttpStatus.OK);
	}
	
	
}
