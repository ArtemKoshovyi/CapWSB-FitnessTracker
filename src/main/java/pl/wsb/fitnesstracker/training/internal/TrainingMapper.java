package pl.wsb.fitnesstracker.training.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingDto;

import java.util.List;
/**
 * Maps Training entities to DTOs.
 */
@Component
class TrainingMapper {

    TrainingDto toDto(Training training) {
        return new TrainingDto(
                training.getId(),
                training.getStartTime(),
                training.getEndTime(),
                training.getActivityType(),
                training.getDistance(),
                training.getAverageSpeed(),
                training.getUser().getId()
        );
    }

    List<TrainingDto> toDtos(List<Training> trainings) {
        return trainings.stream().map(this::toDto).toList();
    }
}
