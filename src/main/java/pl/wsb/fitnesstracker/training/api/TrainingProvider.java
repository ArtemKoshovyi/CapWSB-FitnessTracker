package pl.wsb.fitnesstracker.training.api;

import java.util.List;
import java.util.Optional;
/**
 * Provides access to training data.
 */
public interface TrainingProvider {

    Optional<Training> getTraining(Long trainingId);

    /**
     * Returns all trainings.
     */
    List<Training> findAllTrainings();

    /**
     * Returns trainings for given user id.
     */
    List<Training> findTrainingsByUserId(Long userId);
}
