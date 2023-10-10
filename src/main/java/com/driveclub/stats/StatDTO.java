package com.driveclub.stats;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class StatDTO {
    @Getter
    private Long id;

    @Getter @Setter
    private String car;

    @Getter @Setter
    private String track;

    @Getter @Setter
    private Long driver_id;

    @Getter @Setter
    private BigDecimal split_one;

    @Getter @Setter
    private BigDecimal split_two;

    @Getter @Setter
    private BigDecimal split_three;

    @Getter @Setter
    private BigDecimal laptime;

    @Getter
    private OffsetDateTime created_at;
}
