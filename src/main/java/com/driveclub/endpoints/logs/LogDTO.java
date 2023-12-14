package com.driveclub.endpoints.logs;

import jakarta.persistence.Column;
import lombok.Getter;

import java.time.OffsetDateTime;

public class LogDTO {
    @Getter
    private Long id;

    @Getter
    private OffsetDateTime date;

    @Getter
    private String event;
}
