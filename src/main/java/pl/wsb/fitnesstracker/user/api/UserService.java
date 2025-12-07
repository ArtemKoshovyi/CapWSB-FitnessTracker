package pl.wsb.fitnesstracker.user.api;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within appropriate transactional context.
 */
public interface UserService {

    /**
     * Creates a new user.
     *
     * @param user The user to be created
     * @return The created user
     */
    User createUser(User user);

    /**
     * Updates existing user.
     *
     * @param user user entity with ID set and new values of fields
     * @return updated user
     */
    User updateUser(User user);

    /**
     * Deletes user by ID.
     *
     * @param userId ID of user to delete
     */
    void deleteUser(Long userId);
}
