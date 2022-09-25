package run.chaos.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import run.chaos.weather.model.Wind;
import run.chaos.weather.repository.WindRepository;

@Service
public class WindService {
    @Autowired
    private WindRepository windRepository;

    public Wind addWind(Wind wind) {
        return windRepository.save(wind);
    }
}
