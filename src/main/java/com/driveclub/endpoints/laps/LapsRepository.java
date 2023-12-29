package com.driveclub.endpoints.laps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public interface LapsRepository extends JpaRepository<Lap, Integer>, JpaSpecificationExecutor<Lap> {
    @Query(value = "" +
            "SELECT " +
            "new com.driveclub.endpoints.laps.LapOverviewsDTO( " +
                "l.id," +
                "l.driver.name," +
                "l.track," +
                "l.laptime," +
                "l.s1," +
                "l.s2," +
                "l.s3," +
                "l.valid" +
            ") " +
            "FROM Lap l " +
            "WHERE l.session.id = :sessionID AND l.driver.id = :driverID " +
            "ORDER BY l.id ASC")
    List<LapOverviewsDTO> getDriverSessionLaps(@Param("sessionID") UUID sessionID, @Param("driverID") Long driverID);
}
