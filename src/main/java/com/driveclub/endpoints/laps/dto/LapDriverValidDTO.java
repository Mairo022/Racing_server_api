package com.driveclub.endpoints.laps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class LapDriverValidDTO {
    private int id;
    private String car;
    private String track;
    private String laptime;
    private String s1;
    private String s2;
    private String s3;
    private Date date;
}
