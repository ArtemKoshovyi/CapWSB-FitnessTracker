package pl.wsb.fitnesstracker.workoutsession;

import jakarta.persistence.*;
<<<<<<< HEAD
import pl.wsb.fitnesstracker.training.api.Training;

import java.time.Instant;

@Entity
@Table(name = "workout_session")
=======
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wsb.fitnesstracker.training.api.Training;

import java.time.LocalDateTime;

@Entity
@Table(name = "workout_session")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
=======
    @ManyToOne(fetch = FetchType.LAZY)
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @Column(name = "timestamp", nullable = false)
<<<<<<< HEAD
    private Instant timestamp;

    @Column(name = "start_latitude")
    private Double startLatitude;

    @Column(name = "start_longitude")
    private Double startLongitude;
=======
    private LocalDateTime timestamp;

    @Column(name = "start_latitude", nullable = false)
    private double startLatitude;

    @Column(name = "start_longitude", nullable = false)
    private double startLongitude;
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0

    @Column(name = "end_latitude")
    private Double endLatitude;

    @Column(name = "end_longitude")
    private Double endLongitude;

    @Column(name = "altitude")
    private Double altitude;
<<<<<<< HEAD
=======

>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
}
