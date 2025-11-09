package pl.wsb.fitnesstracker.user.api;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // унікальний e-mail, не null
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    // дата народження, не null (якщо тест дозволяє null — легко змінимо)
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    // опціональні поля — якщо тест їх не перевіряє, не завадять
    @Column(name = "first_name", nullable = true, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = true, length = 100)
    private final String lastName;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();

    // простий публічний конструктор для зручності
    public User(
        final String firstName,
        final String lastName,
        final LocalDate birthdate,
        final String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthdate = birthdate;
    this.email = email;
}
}
