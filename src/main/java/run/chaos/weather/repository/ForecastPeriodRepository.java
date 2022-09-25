package run.chaos.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import run.chaos.weather.model.ForecastPeriod;

import java.util.Optional;

public interface ForecastPeriodRepository extends JpaRepository<ForecastPeriod, Integer> {
    Optional<ForecastPeriod> findById(int id);
}
