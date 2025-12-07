package pl.wsb.fitnesstracker.user.internal;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserNotFoundException;
import pl.wsb.fitnesstracker.user.api.UserProvider;
import pl.wsb.fitnesstracker.user.api.UserService;

import java.util.List;

<<<<<<< HEAD
=======
import java.util.List;

/**
 * UserController is responsible for handling HTTP requests related to user operations.
 * It provides endpoints for retrieving and creating users.
 */
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
@RestController
@RequestMapping("/v1/users")
class UserController {

    private final UserService userService;
    private final UserProvider userProvider;
    private final UserMapper userMapper;

<<<<<<< HEAD
    UserController(UserService userService,
                   UserProvider userProvider,
                   UserMapper userMapper) {
        this.userService = userService;
        this.userProvider = userProvider;
        this.userMapper = userMapper;
=======
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
    }
}

<<<<<<< HEAD
    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        var user = userMapper.toEntity(userDto);
        var created = userService.createUser(user);
        return userMapper.toDto(created);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userMapper.toDtos(userProvider.findAllUsers());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userProvider.getUser(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/by-email")
    public UserDto getUserByEmail(@RequestParam String email) {
        return userProvider.getUserByEmail(email)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException(-1L)); // можно сделать отдельный конструктор
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto dto) {
        var user = userMapper.toEntity(dto);
        user = new pl.wsb.fitnesstracker.user.api.User(
                dto.firstName(),
                dto.lastName(),
                dto.birthdate(),
                dto.email()
        );
        user = new pl.wsb.fitnesstracker.user.api.User(
                dto.firstName(),
                dto.lastName(),
                dto.birthdate(),
                dto.email()
        );
        user = userService.updateUser(
                new pl.wsb.fitnesstracker.user.api.User(
                        dto.firstName(),
                        dto.lastName(),
                        dto.birthdate(),
                        dto.email()
                ) {
                    {
                    }
                }
        );
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/search/by-email")
    public List<UserDto> searchByEmailFragment(@RequestParam String fragment) {
        return userMapper.toDtos(userProvider.findUsersByEmailFragment(fragment));
    }

    @GetMapping("/search/by-age")
    public List<UserDto> searchByAge(@RequestParam("ageGreaterThan") int ageGreaterThan) {
        return userMapper.toDtos(userProvider.findUsersOlderThan(ageGreaterThan));
    }
}
=======
>>>>>>> 0d8093fc29c6e4dd5ecac0c230bdeb91515947e0
