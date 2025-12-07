package pl.wsb.fitnesstracker.event;

<<<<<<< HEAD

=======
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
import lombok.ToString;

import java.time.Instant;

@Entity
@Table(name="event")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

=======

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
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


=======
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
}
