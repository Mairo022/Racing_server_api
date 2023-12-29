package com.driveclub.endpoints.laps;

import com.driveclub.endpoints.drivers.Driver;
import com.driveclub.endpoints.sessions.Session;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class LapDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private int id;
    private Session session;
    private Driver driver;
    private String car;
    private String track;
    private String laptime;
    private String s1;
    private String s2;
    private String s3;
    private boolean valid;
    private short cuts;
    private short crashesCars;
    private short crashesEnv;
    private String pitTime;
    private String pitlaneTime;
    private short grip;
    private BigDecimal maximumSpeed;
    private Date date;
}
