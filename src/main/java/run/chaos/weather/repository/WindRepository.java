package run.chaos.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import run.chaos.weather.model.Wind;

import java.util.Optional;

public interface WindRepository extends JpaRepository<Wind, Integer> {
    Optional<Wind> findById(int id);
}
