package pl.wsb.fitnesstracker.user.api;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    private String firstName;

    private String lastName;

=======
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(name = "birthdate", nullable = false)
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
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
}
