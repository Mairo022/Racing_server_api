package com.driveclub.endpoints.drivers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DriverDTO {
    private Long id;
    private String name;
    private Integer money;
    private Integer wins;
    private Integer podiums;
    private Integer poles;
    private BigDecimal driven;
    private Integer crashes;
    private BigDecimal crashes_per_hundred_km;
    private Integer infr;
    private BigDecimal infr_per_hundred_km;
}
