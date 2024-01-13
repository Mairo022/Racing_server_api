package com.driveclub.endpoints.stats;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class StatDTO {
    @Setter(AccessLevel.NONE)
    private Long id;
    private String car;
    private String track;
    private Long driver_id;
    private BigDecimal split_one;
    private BigDecimal split_two;
    private BigDecimal split_three;
    private BigDecimal laptime;

    @Setter(AccessLevel.NONE)
    private OffsetDateTime created_at;
}
