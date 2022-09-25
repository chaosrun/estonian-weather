package run.chaos.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import run.chaos.weather.model.Forecast;

import java.time.LocalDate;
import java.util.Optional;

public interface ForecastRepository extends JpaRepository<Forecast, Integer> {
    Optional<Forecast> findById(int id);

    Optional<Forecast> findByDate(LocalDate date);
}
