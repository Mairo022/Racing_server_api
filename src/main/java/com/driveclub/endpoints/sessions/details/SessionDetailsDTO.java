package com.driveclub.endpoints.sessions.details;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Data
public class SessionDetailsDTO {
    @Setter(AccessLevel.NONE)
    private Long id;

    private UUID session_id;

    private String car;

    private String total_time;

    private String fastest_lap;

    private String gap_to_first;

    private String rank;

    private Long driver_id;
}
