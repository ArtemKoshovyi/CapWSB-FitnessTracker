package pl.wsb.fitnesstracker.training.api;

import pl.wsb.fitnesstracker.training.internal.ActivityType;

import java.util.Date;
/**
 * DTO representing training data returned by API.
 */
public record TrainingDto(
        Long id,
        Date startTime,
        Date endTime,
        ActivityType activityType,
        double distance,
        double averageSpeed,
        Long userId
) {}
