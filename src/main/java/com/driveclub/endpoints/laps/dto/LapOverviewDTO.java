package com.driveclub.endpoints.laps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class LapOverviewDTO {
    private int lapID;
    private String driver;
    private String track;
    private String laptime;
    private String s1;
    private String s2;
    private String s3;
    private boolean valid;
    private Date date;
}
