package com.driveclub.endpoints.sessions.details;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Data
public class SessionDetailsDTO {
    @Setter(AccessLevel.NONE)
    private Long id;

    private UUID sessionID;

    private String car;

    private String totalTime;

    private String fastestLap;

    private String gapToFirst;

    private String rank;

    private Long driver_id;
}
