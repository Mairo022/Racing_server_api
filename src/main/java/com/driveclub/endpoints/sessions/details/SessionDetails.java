package com.driveclub.endpoints.sessions.details;

import com.driveclub.endpoints.drivers.Driver;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Data
@Entity
@Table(name = "sessions_details")
public class SessionDetails {
    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    @Column
    private Long id;

    @Column(nullable = false, name = "session_id")
    private UUID sessionID;

    @Column(nullable = false, length = 100)
    private String car;

    @Column(length = 12, name = "total_time")
    private String totalTime;

    @Column(length = 12, name = "fastest_lap")
    private String fastestLap;

    @Column(length = 12, name = "gap_to_first")
    private String gapToFirst;

    @Column(length = 4)
    private String rank;
}
