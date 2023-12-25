package com.driveclub.endpoints.sessions.details;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SessionDetailsRepository extends JpaRepository<SessionDetails, Long>, JpaSpecificationExecutor<SessionDetails> {
    @Query(value = "" +
            "SELECT " +
                "new com.driveclub.endpoints.sessions.details.SessionDetailsDTO( " +
                "sd.id, " +
                "sd.sessionID, " +
                "sd.car, " +
                "sd.totalTime, " +
                "sd.fastestLap, " +
                "sd.gapToFirst, " +
                "sd.rank, " +
                "sd.driver.name) " +
            "FROM SessionDetails sd " +
            "WHERE sd.sessionID = :sessionID")
    List<SessionDetailsDTO> getDetails(Pageable pageable, @Param("sessionID") UUID sessionID);
}

