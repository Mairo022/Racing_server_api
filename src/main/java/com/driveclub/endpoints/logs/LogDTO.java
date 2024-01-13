package com.driveclub.endpoints.logs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class LogDTO {
    private Long id;
    private OffsetDateTime date;
    private String event;
}
