package com.driveclub.sessions;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

public class SessionDTO {
    @Getter
    private Long id;

    @Getter @Setter
    private UUID session_id;

    @Getter @Setter
    private Long driver_id;

    @Getter @Setter
    private Integer position;

    @Getter @Setter
    private String track;

    @Getter @Setter
    private String car;

    @Getter
    private OffsetDateTime created_at;
}
