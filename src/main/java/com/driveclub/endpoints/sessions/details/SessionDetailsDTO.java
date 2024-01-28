package com.driveclub.endpoints.sessions.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDetailsDTO {
    private Long id;
    private UUID sessionID;
    private String car;
    private String totalTime;
    private String fastestLap;
    private String gapToFirst;
    private short rank;
    private String name;
    private Long driverID;
}
