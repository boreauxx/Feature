package feature.repository;

import feature.entity.models.program.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    Optional<Day> findFirstByDate(LocalDate date);
}
