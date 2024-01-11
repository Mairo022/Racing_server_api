package com.driveclub.endpoints.cars;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping(value = "getAll")
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping(value = "getAllCars")
    public ResponseEntity<List<String>> getAllCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }
}
