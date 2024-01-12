package com.driveclub.endpoints.laps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class LapLeaderboardDTO {
    private int id;
    private String driver;
    private String laptime;
    private String s1;
    private String s2;
    private String s3;
    private Date date;
}
