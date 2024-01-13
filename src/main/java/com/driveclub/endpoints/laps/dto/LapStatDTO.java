package com.driveclub.endpoints.laps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LapStatDTO {
    private LapDTO lap;
    private int totalLaps;
}
