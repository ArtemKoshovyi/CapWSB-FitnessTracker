package pl.wsb.fitnesstracker.training.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository for Training entities.
 */
@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
}
