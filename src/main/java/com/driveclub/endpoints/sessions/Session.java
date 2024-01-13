package com.driveclub.endpoints.sessions;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name="sessions")
public class Session {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, length = 10)
    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Date date;

    @Column(precision = 4, scale = 1)
    private BigDecimal fuel_rate;

    @Column(precision = 3, scale = 1)
    private BigDecimal tyre_wear_rate;

    private Short air_temp;
    private Short road_temp;

    @Column(nullable = false, length = 100)
    private String track;

    private boolean penalties;
    private Short damage;

    @Column(length = 8)
    private String duration;

    @Column(nullable = false, length = 200)
    private String server;
}
