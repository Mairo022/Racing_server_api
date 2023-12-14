package com.driveclub.endpoints.sessions;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class SessionDTO {
    @Getter @Setter
    private UUID id;

    @Getter @Setter
    private String type;

    @Getter @Setter
    private Date date;

    @Getter @Setter
    private BigDecimal fuel_rate;

    @Getter @Setter
    private BigDecimal tyre_wear_rate;

    @Getter @Setter
    private Short air_temp;

    @Getter @Setter
    private Short road_temp;

    @Getter @Setter
    private String track;

    @Getter @Setter
    private boolean penalties;

    @Getter @Setter
    private Short damage;

    @Getter @Setter
    private String duration;

    @Getter @Setter
    private String server;
}
