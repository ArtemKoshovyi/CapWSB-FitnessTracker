package pl.wsb.fitnesstracker.user.internal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserNotFoundException;
import pl.wsb.fitnesstracker.user.api.UserProvider;
import pl.wsb.fitnesstracker.user.api.UserService;

import java.time.LocalDate;
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
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        var user = userMapper.toEntity(userDto);
        var created = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toDto(created));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(
                userMapper.toDtos(userProvider.findAllUsers())
        );
    }

    // ✔ ТЕСТ: /v1/users/simple
    @GetMapping("/simple")
    public ResponseEntity<List<UserDto>> getSimpleUsers() {
        return ResponseEntity.ok(
                userMapper.toDtos(userProvider.findAllUsers())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return userProvider.getUser(id)
                .map(userMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // ✔ ТЕСТ: /v1/users/email?email=...
    @GetMapping("/email")
    public ResponseEntity<List<UserDto>> getUserByEmail(@RequestParam("email") String email) {
        return userProvider.getUserByEmail(email)
                .map(userMapper::toDto)
                .map(List::of)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundException(-1L));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto dto) {
        var user = userMapper.toEntity(dto);

        try {
            var idField = User.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(user, id);
        } catch (Exception ignored) {}

        var updated = userService.updateUser(user);
        return ResponseEntity.ok(userMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // ✔ ТЕСТ: /v1/users/older/{time}
    @GetMapping("/older/{time}")
    public ResponseEntity<List<UserDto>> getOlderThan(@PathVariable("time") LocalDate time) {
        return ResponseEntity.ok(
                userMapper.toDtos(userProvider.findUsersOlderThan(time))
        );
    }
}
