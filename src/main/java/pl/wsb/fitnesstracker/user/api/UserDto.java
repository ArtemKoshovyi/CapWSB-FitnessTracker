package pl.wsb.fitnesstracker.user.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;

import java.time.LocalDate;
/**
 * DTO representing full user data.
 * Used for creating, updating and retrieving users.
 */
public record UserDto(@Nullable Long id,
                      String firstName,
                      String lastName,
                      @JsonFormat(pattern = "yyyy-MM-dd")
                      LocalDate birthdate,
                      String email) {

}
