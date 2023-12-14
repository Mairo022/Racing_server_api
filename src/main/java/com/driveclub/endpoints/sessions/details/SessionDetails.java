package com.driveclub.endpoints.sessions.details;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Data
@Entity
@Table(name = "sessions_details")
public class SessionDetails {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    @Column
    private Long id;

    @Column(nullable = false)
    private UUID session_id;

    @Column(nullable = false, length = 100)
    private String car;

    @Column(length = 12)
    private String total_time;

    @Column(length = 12)
    private String fastest_lap;

    @Column(length = 12)
    private String gap_to_first;

    @Column(length = 4)
    private String rank;

    private Long driver_id;
}
