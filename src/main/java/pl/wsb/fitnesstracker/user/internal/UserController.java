package pl.wsb.fitnesstracker.user.internal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.*;

import java.time.LocalDate;
import java.util.List;

/**
 * REST controller for user management.
 */

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

    /**
     * Creates a new user.
     */
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        var user = userMapper.toEntity(userDto);
        var created = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toDto(created));
    }

    /**
     * Returns all users.
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(
                userMapper.toDtos(userProvider.findAllUsers())
        );
    }

    /**
     * Returns user by id.
     */
    @GetMapping("/simple")
    public ResponseEntity<List<UserBasicDto>> getSimpleUsers() {
        return ResponseEntity.ok(
                userMapper.toBasicDtos(userProvider.findAllUsers())
        );
    }

    /**
     * Searches users by email fragment.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return userProvider.getUser(id)
                .map(userMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // ✔ ТЕСТ: /v1/users/email?email=...
    @GetMapping("/email")
    public ResponseEntity<List<UserEmailDto>> searchByEmail(
            @RequestParam("email") String fragment
    ) {
        return ResponseEntity.ok(
                userMapper.toEmailDtos(
                        userProvider.findUsersByEmailFragment(fragment)
                )
        );
    }



    /**
     * Updates user data.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable Long id,
            @RequestBody UserDto dto)
    {
        var user = userMapper.toEntity(dto);

        try {
            var idField = User.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(user, id);
        } catch (Exception ignored) {}

        var updated = userService.updateUser(user);
        return ResponseEntity.ok(userMapper.toDto(updated));
    }
    /**
     * Deletes user by id.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Returns users older than given date.
     */
    @GetMapping("/older/{time}")
    public ResponseEntity<List<UserDto>> getOlderThan(@PathVariable("time") LocalDate time) {
        return ResponseEntity.ok(
                userMapper.toDtos(userProvider.findUsersOlderThan(time))
        );
    }
}
