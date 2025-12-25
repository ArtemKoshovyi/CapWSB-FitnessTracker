package pl.wsb.fitnesstracker.training.api;

/**
 * DTO representing user data in training context.
 */
public record TrainingUserDto(
        Long id,
        String firstName,
        String lastName,
        String email
) {
}
