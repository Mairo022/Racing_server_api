package com.driveclub.endpoints.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Short>, JpaSpecificationExecutor<Car> {
    @Query(value="SELECT car FROM Car")
    List<String> findAllCars();
}