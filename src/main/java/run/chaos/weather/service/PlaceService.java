package run.chaos.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import run.chaos.weather.model.Place;
import run.chaos.weather.repository.PlaceRepository;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }
}
