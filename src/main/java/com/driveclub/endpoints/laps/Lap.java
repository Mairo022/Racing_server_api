package com.driveclub.endpoints.laps;

import com.driveclub.endpoints.drivers.Driver;
import com.driveclub.endpoints.sessions.Session;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name="laps")
public class Lap {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    @Column(nullable = false, length = 100)
    private String car;

    @Column(nullable = false, length = 100)
    private String track;

    @Column(length = 11)
    private String laptime;

    @Column(length = 11)
    private String s1;

    @Column(length = 11)
    private String s2;

    @Column(length = 11)
    private String s3;

    @Column(nullable = false)
    private boolean valid;

    private short cuts;

    @Column(name = "crashes_cars")
    private short crashesCars;

    @Column(name = "crashes_env")
    private short crashesEnv;

    @Column(length = 11, name = "pit_time")
    private String pitTime;

    @Column(length = 11, name = "pitlane_time")
    private String pitlaneTime;

    private short grip;

    @Column(precision = 5, scale = 1, name = "maximum_speed")
    private BigDecimal maximumSpeed;

    private Date date;
}
