package com.driveclub.drivers;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class DriverDTO {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Integer money;

    @Getter @Setter
    private Integer wins;

    @Getter @Setter
    private Integer podiums;

    @Getter @Setter
    private Integer poles;

    @Getter @Setter
    private BigDecimal driven;

    @Getter @Setter
    private Integer crashes;

    @Getter @Setter
    private BigDecimal crashes_per_hundred_km;

    @Getter @Setter
    private Integer infr;

    @Getter @Setter
    private BigDecimal infr_per_hundred_km;
}
