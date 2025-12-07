package pl.wsb.fitnesstracker.event;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Entity
@Table(name="event")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="start-time", nullable = false)
    private Instant startTime;

    @Column(name="end-time", nullable = false)
    private Instant endTime;

    @Column(name="contry", nullable = false)
    private String contry;

    @Column(name="city", nullable = false)
    private String city;


}
