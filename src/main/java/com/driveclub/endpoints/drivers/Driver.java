package com.driveclub.endpoints.drivers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name="drivers")
public class Driver {
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer money;

    @Column(nullable = false)
    private Integer wins;

    @Column(nullable = false)
    private Integer podiums;

    @Column(nullable = false)
    private Integer poles;

    @Column(length = 9, precision = 2, nullable = false)
    private BigDecimal driven;

    @Column(nullable = false)
    private Integer crashes;

    @Column(length = 5, precision = 2, nullable = false)
    private BigDecimal crashes_per_hundred_km;

    @Column(nullable = false)
    private Integer infr;

    @Column(length = 5, precision = 2, nullable = false)
    private BigDecimal infr_per_hundred_km;
}
