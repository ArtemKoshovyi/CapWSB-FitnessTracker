package pl.wsb.fitnesstracker.training.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findByUser_IdAndStartTimeBetween(
            Long userId,
            Date from,
            Date to
    );

    long countByUser_Id(Long userId);
}
