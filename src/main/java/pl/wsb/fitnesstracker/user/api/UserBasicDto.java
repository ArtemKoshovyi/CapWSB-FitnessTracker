package pl.wsb.fitnesstracker.user.api;

/**
 * DTO representing basic user information.
 * Used for lightweight user listings.
 */

public record UserBasicDto(
        Long id,
        String firstName,
        String lastName
) {}
