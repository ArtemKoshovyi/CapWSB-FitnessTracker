package pl.wsb.fitnesstracker.training.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingDto;
import pl.wsb.fitnesstracker.training.api.TrainingUserDto;

import java.util.List;

/**
 * Maps Training entities to DTOs.
 */
@Component
class TrainingMapper {

    TrainingDto toDto(Training training) {
        var user = training.getUser();

        return new TrainingDto(
                training.getId(),
                training.getStartTime(),
                training.getEndTime(),
                training.getActivityType(),
                training.getDistance(),
                training.getAverageSpeed(),
                new TrainingUserDto(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail()
                )
        );
    }

    List<TrainingDto> toDtos(List<Training> trainings) {
        return trainings.stream()
                .map(this::toDto)
                .toList();
    }
}
