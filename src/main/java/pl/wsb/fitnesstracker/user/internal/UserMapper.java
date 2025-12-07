package pl.wsb.fitnesstracker.user.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;

import java.util.List;
@Component
class UserMapper {

    UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail()
        );
    }

    User toEntity(UserDto dto) {
        var user = new User(
                dto.firstName(),
                dto.lastName(),
                dto.birthdate(),
                dto.email()
        );

        // Если ID передан — устанавливаем
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

    List<UserDto> toDtos(List<User> users) {
        return users.stream().map(this::toDto).toList();
    }
}
