package com.driveclub.stats;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name="stats")
public class Stat {
    @Id @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private int id;

    @Getter @Setter
    @Column
    private UUID track_id;

    @Getter @Setter
    @Column
    private UUID driver_id;

    @Getter @Setter
    @Column(precision = 8, scale = 3)
    private BigDecimal split_one;

    @Getter @Setter
    @Column(precision = 8, scale = 3)
    private BigDecimal split_two;

    @Getter @Setter
    @Column(precision = 8, scale = 3)
    private BigDecimal split_three;

    @Getter @Setter
    @Column(precision = 8, scale = 3)
    private BigDecimal laptime;
}
