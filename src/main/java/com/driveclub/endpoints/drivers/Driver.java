package com.driveclub.endpoints.drivers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Data
@Table(name="drivers")
public class Driver {
    @Id @Getter @Setter
    @Column(nullable = false)
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String name;

    @Getter @Setter
    @Column(nullable = false)
    private Integer money;

    @Getter @Setter
    @Column(nullable = false)
    private Integer wins;

    @Getter @Setter
    @Column(nullable = false)
    private Integer podiums;

    @Getter @Setter
    @Column(nullable = false)
    private Integer poles;

    @Getter @Setter
    @Column(length = 9, precision = 2, nullable = false)
    private BigDecimal driven;

    @Getter @Setter
    @Column(nullable = false)
    private Integer crashes;

    @Getter
    @Column(length = 5, precision = 2, nullable = false)
    private BigDecimal crashes_per_hundred_km;

    @Getter @Setter
    @Column(nullable = false)
    private Integer infr;

    @Getter
    @Column(length = 5, precision = 2, nullable = false)
    private BigDecimal infr_per_hundred_km;
}
