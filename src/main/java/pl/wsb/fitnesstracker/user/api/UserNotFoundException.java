package pl.wsb.fitnesstracker.user.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.wsb.fitnesstracker.exception.api.NotFoundException;

/**
 * Exception indicating that the {@link User} was not found.
 */
@SuppressWarnings("squid:S110")

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends NotFoundException {

    private UserNotFoundException(String message)
    {
        super(message);
    }

    public UserNotFoundException(Long id)
    {
        this("User with ID=%s was not found".formatted(id));
    }

}
