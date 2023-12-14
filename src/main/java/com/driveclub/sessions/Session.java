package com.driveclub.sessions;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="sessions")
public class Session {
    @Id @Getter @Setter
    @Column(nullable = false)
    private UUID id;

    @Getter @Setter
    @Column(nullable = false, length = 10)
    private String type;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Date date;

    @Getter @Setter
    @Column(precision = 4, scale = 1)
    private BigDecimal fuel_rate;

    @Getter @Setter
    @Column(precision = 3, scale = 1)
    private BigDecimal tyre_wear_rate;

    @Getter @Setter
    @Column
    private Short air_temp;

    @Getter @Setter
    @Column
    private Short road_temp;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String track;

    @Getter @Setter
    @Column
    private boolean penalties;

    @Getter @Setter
    @Column
    private Short damage;

    @Getter @Setter
    @Column(length = 8)
    private String duration;

    @Getter @Setter
    @Column(nullable = false, length = 200)
    private String server;
}
