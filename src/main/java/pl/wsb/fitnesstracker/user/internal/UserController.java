package pl.wsb.fitnesstracker.user.internal;

import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserNotFoundException;
import pl.wsb.fitnesstracker.user.api.UserProvider;
import pl.wsb.fitnesstracker.user.api.UserService;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
class UserController {

    private final UserService userService;
    private final UserProvider userProvider;
    private final UserMapper userMapper;

    UserController(UserService userService,
                   UserProvider userProvider,
                   UserMapper userMapper) {
        this.userService = userService;
        this.userProvider = userProvider;
        this.userMapper = userMapper;
    }

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

    /** Обновление пользователя (любой атрибут) */
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
                    { // анонимный блок не нужен, см. комментарий ниже
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
