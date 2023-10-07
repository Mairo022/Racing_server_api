package com.driveclub.sessions;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;

    @Getter
    @Column
    private OffsetDateTime date;

    @Getter @Setter
    @Column
    private Long driver_id;

    @Getter @Setter
    @Column(length = 3)
    private String position;

    @Getter @Setter
    @Column
    private UUID session_id;
}
