package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Car;
import com.example.repositories.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository repository;

	@Override
	public List<Car> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Car getById(Long id) {
		return this.repository.getOne(id);
	}

	@Override
	public Car create(Car car) {
		return this.repository.save(car);
	}

	@Override
	public Car delete(Long id) {
		Car car = this.getById(id);
		if ( car != null) {
			this.repository.delete(car);
		}
		
		return car;
		
	}

}
