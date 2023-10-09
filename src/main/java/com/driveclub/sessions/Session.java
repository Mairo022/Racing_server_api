package com.driveclub.sessions;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name="sessions")
public class Session {
    @Id @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private UUID session_id;

    @Getter @Setter
    @Column(nullable = false)
    private Long driver_id;

    @Getter @Setter
    @Column(nullable = false)
    private Integer position;

    @Getter @Setter
    @Column(nullable = false)
    private String track;

    @Getter @Setter
    @Column(nullable = false)
    private String car;

    @Getter
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime created_at;
}
