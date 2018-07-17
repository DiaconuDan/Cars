package com.example.services;

import java.util.List;

import com.example.domain.Car;

public interface CarService {
	List<Car> findAll();

	Car getById(Long id);
	
	Car create(Car car);
	
	Car delete(Long id);

}
