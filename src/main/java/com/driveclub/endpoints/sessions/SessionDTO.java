package com.driveclub.endpoints.sessions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class SessionDTO {
    private UUID id;
    private String type;
    private Date date;
    private BigDecimal fuel_rate;
    private BigDecimal tyre_wear_rate;
    private Short air_temp;
    private Short road_temp;
    private String track;
    private boolean penalties;
    private Short damage;
    private String duration;
    private String server;
}
