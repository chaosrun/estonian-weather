package run.chaos.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import run.chaos.weather.model.Place;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    Optional<Place> findById(int id);
}
