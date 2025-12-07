package pl.wsb.fitnesstracker.event;


import jakarta.persistence.*;
<<<<<<< HEAD
import pl.wsb.fitnesstracker.user.api.User;

=======
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.fitnesstracker.user.api.User;

@Entity
@Table(name = "user_event",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "event_id"}))
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="event_id", nullable = false)
    private Event event;

    @Column(name = "status", nullable = false)
    private String status;

}
=======
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "status")
    @Setter
    private String status;
}


>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
