package pl.wsb.fitnesstracker.user.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserProvider {

    Optional<User> getUser(Long userId);

    Optional<User> getUserByEmail(String email);

    List<User> findAllUsers();

    /**
     * Search users by e-mail fragment (case-insensitive).
     *
     * @param emailFragment fragment of e-mail
     * @return list of matching users
     */
    List<User> findUsersByEmailFragment(String emailFragment);

    /**
     * Find users older than given age (in years).
     *
     * @param age age threshold
     * @return list of users older than age
     */
    List<User> findUsersOlderThan(LocalDate beforeDate);
}
