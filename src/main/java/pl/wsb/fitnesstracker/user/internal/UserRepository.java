package pl.wsb.fitnesstracker.user.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.time.LocalDate.now;

/**
 * Repository for User entities.
 */
interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds user by email.
     */
    default Optional<User> findByEmail(String email) {
        return findAll().stream()
                .filter(user -> Objects.equals(user.getEmail(), email))
                .findFirst();
    }
    /**
     * Finds users by email fragment (case-insensitive).
     */
    default List<User> findByEmailFragmentIgnoreCase(String fragment) {
        final String lower = fragment.toLowerCase();
        return findAll().stream()
                .filter(u -> u.getEmail() != null &&
                        u.getEmail().toLowerCase().contains(lower))
                .toList();
    }
    /**
     * Finds users older than given age.
     */
    default List<User> findOlderThan(int age) {
        LocalDate borderDate = now().minusYears(age);
        return findAll().stream()
                .filter(u -> u.getBirthdate() != null &&
                        u.getBirthdate().isBefore(borderDate))
                .toList();
    }


}
