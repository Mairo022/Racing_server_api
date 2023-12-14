package com.driveclub.endpoints.stats;

import jakarta.persistence.*;
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
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String track;

    @Getter @Setter
    @Column(nullable = false)
    private String car;

    @Getter @Setter
    @Column(nullable = false)
    private Long driver_id;

    @Getter @Setter
    @Column(length = 10, precision = 3, nullable = false)
    private BigDecimal split_one;

    @Getter @Setter
    @Column(length = 10, precision = 3, nullable = false)
    private BigDecimal split_two;

    @Getter @Setter
    @Column(length = 10, precision = 3, nullable = false)
    private BigDecimal split_three;

    @Getter @Setter
    @Column(length = 10, precision = 3, nullable = false)
    private BigDecimal laptime;

    @Getter
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime created_at;
}
