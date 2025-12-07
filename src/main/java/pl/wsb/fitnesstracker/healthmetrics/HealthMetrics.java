package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.persistence.*;
<<<<<<< HEAD
import pl.wsb.fitnesstracker.user.api.User;

import java.time.Instant;

@Entity
@Table(name = "health_metrics")
=======
import lombok.Getter;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;

/* Entity class representing health metrics.
 * To be implemented with appropriate fields and methods.
 */
@Entity
@Table(name = "Health_Metrics")
@Getter
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "height_cm", nullable = true)
    private Integer heightCm;

    @Column(name = "weight_kg", nullable = true)
    private Double weightKg;

    @Column(name = "bmi", nullable = true)
    private Double bmi;

    @Column(name = "recorded_at", nullable = false)
    private Instant recordedAt = Instant.now();

    // --- getters/setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Integer getHeightCm() { return heightCm; }
    public void setHeightCm(Integer heightCm) { this.heightCm = heightCm; }

    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }

    public Double getBmi() { return bmi; }
    public void setBmi(Double bmi) { this.bmi = bmi; }

    public Instant getRecordedAt() { return recordedAt; }
    public void setRecordedAt(Instant recordedAt) { this.recordedAt = recordedAt; }
=======
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column
    private Double weight;

    @Column
    private Double height;

    @Column(name = "heart_rate")
    private Integer heartRate;

    public HealthMetrics() {
    }

    public HealthMetrics(User user, LocalDate date, Double weight, Double height, Integer heartRate) {
        this.user = user;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.heartRate = heartRate;
    }


>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
}
