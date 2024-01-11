package com.driveclub.endpoints.tracks;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "tracks")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private short id;

    @Column(nullable = false, length = 255)
    private String track;

    private Integer length;
}
