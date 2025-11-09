package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.persistence.*;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.Instant;

@Entity
@Table(name = "health_metrics")
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Багато метрик -> один користувач
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
}
