package pl.wsb.fitnesstracker.training.internal;

import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;
import pl.wsb.fitnesstracker.training.api.TrainingRepository;

import java.util.List;
import java.util.Optional;
/**
 * Service implementation for training access.
 */
@Service
class TrainingServiceImpl implements TrainingProvider {

    private final TrainingRepository trainingRepository;

    TrainingServiceImpl(final TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Optional<Training> getTraining(final Long trainingId) {
        return trainingRepository.findById(trainingId);
    }

    @Override
    public List<Training> findAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public List<Training> findTrainingsByUserId(final Long userId) {
        return trainingRepository.findAll().stream()
                .filter(t -> t.getUser() != null)
                .filter(t -> t.getUser().getId() != null)
                .filter(t -> t.getUser().getId().equals(userId))
                .toList();
    }
}
