package com.driveclub.endpoints.logs;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;

@Entity
@Data
@Table(name="logs")
public class Log {
    @Id @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private Long id;

    @Getter
    @Column(nullable = false)
    private OffsetDateTime date;

    @Getter
    @Column(nullable = false)
    private String event;
}
