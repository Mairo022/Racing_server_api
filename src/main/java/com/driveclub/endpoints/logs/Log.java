package com.driveclub.endpoints.logs;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Data
@Table(name="logs")
public class Log {
    @Id @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private OffsetDateTime date;

    @Column(nullable = false)
    private String event;
}
