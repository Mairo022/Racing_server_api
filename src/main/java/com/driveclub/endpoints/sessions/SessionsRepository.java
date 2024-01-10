package com.driveclub.endpoints.sessions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SessionsRepository extends JpaRepository<Session, UUID>, JpaSpecificationExecutor<Session> {
    // Native, because jpa could not find session_id in SessionDetails, to join tables
    @Query(nativeQuery = true, value = "" +
            "SELECT " +
                "s.id AS session_id," +
                "s.type AS type," +
                "s.date AS date," +
                "s.track AS track," +
                "(" +
                    "SELECT COUNT(*) " +
                    "FROM sessions_details " +
                    "WHERE session_id = s.id " +
                ") AS total_drivers," +
                "(" +
                    "SELECT STRING_AGG(sd.driver_id || ',' || sd.total_time || ',' || d.name, ',') " +
                    "FROM ( " +
                        "SELECT " +
                            "driver_id," +
                            "total_time," +
                            "ROW_NUMBER() OVER (PARTITION BY session_id ORDER BY total_time ASC) AS row " +
                        "FROM sessions_details " +
                        "WHERE session_id = s.id" +
                    ") sd " +
                    "JOIN drivers d ON sd.driver_id = d.id " +
                    "WHERE sd.row <= 3" +
                ") AS details " +
            "FROM sessions s",
            countQuery = "SELECT COUNT(*) FROM sessions"
    )
    Page<List> getOverviews(Pageable pageable);
}