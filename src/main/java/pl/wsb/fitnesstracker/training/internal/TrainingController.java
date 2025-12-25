package pl.wsb.fitnesstracker.training.internal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.fitnesstracker.training.api.TrainingDto;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;

import java.util.List;
/**
 * REST controller for training-related endpoints.
 */
@RestController
@RequestMapping("/v1/trainings")
class TrainingController {

    private final TrainingProvider trainingProvider;
    private final TrainingMapper trainingMapper;

    TrainingController(TrainingProvider trainingProvider,
                       TrainingMapper trainingMapper) {
        this.trainingProvider = trainingProvider;
        this.trainingMapper = trainingMapper;
    }
    /**
     * Returns all trainings.
     */
    @GetMapping
    List<TrainingDto> getAllTrainings() {
        return trainingMapper.toDtos(
                trainingProvider.findAllTrainings()
        );
    }
    /**
     * Returns trainings for given user.
     */
    @GetMapping("/user/{userId}")
    List<TrainingDto> getTrainingsByUserId(@PathVariable Long userId) {
        return trainingMapper.toDtos(
                trainingProvider.findTrainingsByUserId(userId)
        );
    }
}
