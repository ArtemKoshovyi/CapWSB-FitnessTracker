package pl.wsb.fitnesstracker.user.api;

import jakarta.persistence.*;
import pl.wsb.fitnesstracker.training.api.Training;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Entity representing application user.
 * Stores personal data and related trainings.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Unique identifier of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** User first name. */
    private String firstName;

    /** User last name. */
    private String lastName;

    /** User birthdate. */
    private LocalDate birthdate;

    @Column(nullable = false, unique = true)
    private String email;

    protected User() {
    }

    public User(String firstName,
                String lastName,
                LocalDate birthdate,
                String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void update(String firstName,
                       String lastName,
                       LocalDate birthdate,
                       String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
    }

    /**
     * List of trainings assigned to the user.
     */
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private List<Training> trainings = new ArrayList<>();

}
