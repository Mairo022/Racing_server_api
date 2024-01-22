package com.driveclub.endpoints.logs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {
    private Long id;
    private OffsetDateTime date;
    private String event;
}
