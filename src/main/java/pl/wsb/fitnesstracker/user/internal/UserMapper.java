package pl.wsb.fitnesstracker.user.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserBasicDto;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserEmailDto;
import java.util.List;

/**
 * Maps User entities to DTOs and vice versa.
 */
@Component
class UserMapper {
    /**
     * Converts User to UserDto.
     */
    UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail()
        );
    }
    /**
     * Converts UserDto to User entity.
     */
    User toEntity(UserDto dto) {
        var user = new User(
                dto.firstName(),
                dto.lastName(),
                dto.birthdate(),
                dto.email()
        );

        if (dto.id() != null) {
            try {
                var idField = User.class.getDeclaredField("id");
                idField.setAccessible(true);
                idField.set(user, dto.id());
            } catch (Exception ignored) {
            }
        }

        return user;
    }
    /**
     * Converts list of Users to UserDtos.
     */
    List<UserDto> toDtos(List<User> users) {
        return users.stream().map(this::toDto).toList();
    }

    UserBasicDto toBasicDto(User user) {
        return new UserBasicDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    /**
     * Converts list of Users to UserBasicDtos.
     */
    List<UserBasicDto> toBasicDtos(List<User> users) {
        return users.stream()
                .map(this::toBasicDto)
                .toList();
    }

    /**
     * Converts User to UserEmailDto.
     */
    UserEmailDto toEmailDto(User user) {
        return new UserEmailDto(
                user.getId(),
                user.getEmail()
        );
    }

    /**
     * Converts list of Users to UserEmailDtos.
     */
    List<UserEmailDto> toEmailDtos(List<User> users) {
        return users.stream()
                .map(this::toEmailDto)
                .toList();
    }


}
