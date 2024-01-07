package com.driveclub.endpoints.laps;

import com.driveclub.endpoints.laps.dto.LapOverviewDTO;
import com.driveclub.endpoints.laps.dto.LapSectorsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LapsRepository extends JpaRepository<Lap, Integer>, JpaSpecificationExecutor<Lap> {
    @Query(value = "" +
            "SELECT " +
            "new com.driveclub.endpoints.laps.dto.LapOverviewDTO( " +
                "l.id," +
                "l.driver.name," +
                "l.track," +
                "l.laptime," +
                "l.s1," +
                "l.s2," +
                "l.s3," +
                "l.valid," +
                "l.date" +
            ") " +
            "FROM Lap l " +
            "WHERE l.session.id = :sessionID AND l.driver.id = :driverID " +
            "ORDER BY l.id ASC")
    List<LapOverviewDTO> getDriverSessionLaps(@Param("sessionID") UUID sessionID, @Param("driverID") Long driverID);

    @Query(value = "" +
            "SELECT " +
            "new com.driveclub.endpoints.laps.dto.LapOverviewDTO( " +
                "l.id," +
                "l.driver.name," +
                "l.track," +
                "l.laptime," +
                "l.s1," +
                "l.s2," +
                "l.s3," +
                "l.valid," +
                "l.date" +
            ") " +
            "FROM Lap l " +
            "WHERE l.car = :car AND l.track = :track ",
            countQuery = "SELECT COUNT(*) FROM Lap l WHERE l.car = :car AND l.track = :track")
    List<LapOverviewDTO> findAllByCarTrack(Pageable pageable, @Param("car") String car, @Param("track") String track);

    @Query(value = "" +
            "SELECT " +
            "new com.driveclub.endpoints.laps.dto.LapSectorsDTO(" +
                "MIN(l.s1), " +
                "MIN(l.s2), " +
                "MIN(l.s3)" +
            ") " +
            "FROM Lap l " +
            "WHERE l.track = :track AND l.driver.id = :driverID AND valid=true")
    LapSectorsDTO getBestSectorTimes(@Param("track") String track, @Param("driverID") Long driverID);

    @Query(value = "SELECT COUNT(*) FROM Lap l WHERE l.driver.id = :driverID AND l.car = :car AND l.track = :track")
    int findLapsCountByDriverIDTrackCar(@Param("driverID") long driverID, @Param("track") String track, @Param("car") String car);
}
