package com.driveclub.endpoints.sessions.details;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SessionDetailsDTO {
    private Long id;

    private UUID sessionID;

    private String car;

    private String totalTime;

    private String fastestLap;

    private String gapToFirst;

    private String rank;

    private String name;
}
