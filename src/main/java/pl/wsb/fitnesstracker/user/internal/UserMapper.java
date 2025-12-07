package pl.wsb.fitnesstracker.user.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;
<<<<<<< HEAD

import java.util.List;
=======
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0

@Component
class UserMapper {

    UserDto toDto(User user) {
<<<<<<< HEAD
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail()
        );
    }

    User toEntity(UserDto dto) {
        return new User(
                dto.firstName(),
                dto.lastName(),
                dto.birthdate(),
                dto.email()
        );
    }

    List<UserDto> toDtos(List<User> users) {
        return users.stream().map(this::toDto).toList();
=======
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail());
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
    }
}
