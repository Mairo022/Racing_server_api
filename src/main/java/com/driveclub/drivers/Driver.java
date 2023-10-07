package com.driveclub.drivers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name="drivers")
public class Driver {
    @Id @Getter @Setter
    private UUID id;

    @Getter @Setter
    @Column
    private String name;

    @Getter @Setter
    @Column
    private Integer money;

    @Getter @Setter
    @Column
    private Integer wins;

    @Getter @Setter
    @Column
    private Integer podiums;

    @Getter @Setter
    @Column
    private Integer poles;

    @Getter @Setter
    @Column(length = 9, precision = 2)
    private BigDecimal driven;

    @Getter @Setter
    @Column
    private Integer crashes;

    @Getter
    @Column(length = 5, precision = 2)
    private BigDecimal crashes_per_hundred_km;

    @Getter @Setter
    @Column
    private Integer infr;

    @Getter
    @Column(length = 5, precision = 2)
    private BigDecimal infr_per_hundred_km;
}
