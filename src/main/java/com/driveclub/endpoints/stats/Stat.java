package com.driveclub.endpoints.stats;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
@Table(name="stats")
public class Stat {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String track;

    @Column(nullable = false)
    private String car;

    @Column(nullable = false)
    private Long driver_id;

    @Column(length = 10, precision = 3, nullable = false)
    private BigDecimal split_one;

    @Column(length = 10, precision = 3, nullable = false)
    private BigDecimal split_two;

    @Column(length = 10, precision = 3, nullable = false)
    private BigDecimal split_three;

    @Column(length = 10, precision = 3, nullable = false)
    private BigDecimal laptime;

    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime created_at;
}
