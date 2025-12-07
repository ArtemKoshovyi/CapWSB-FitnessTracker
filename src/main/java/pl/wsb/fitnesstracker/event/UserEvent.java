package pl.wsb.fitnesstracker.event;


import jakarta.persistence.*;
import pl.wsb.fitnesstracker.user.api.User;

public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="event_id", nullable = false)
    private Event event;

    @Column(name = "status", nullable = false)
    private String status;

}
