package com.driveclub.endpoints.drivers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DriversRepository extends JpaRepository<Driver, Long>, JpaSpecificationExecutor<Driver> {
}
