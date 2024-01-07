package com.driveclub.endpoints.laps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LapStatDTO {
    private LapDTO lap;
    private int totalLaps;
}
