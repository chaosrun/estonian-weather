package run.chaos.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import run.chaos.weather.model.Forecast;
import run.chaos.weather.repository.ForecastRepository;

@Service
public class ForecastService {
    @Autowired
    private ForecastRepository forecastRepository;

    public Forecast addForecast(Forecast forecast) {
        return forecastRepository.save(forecast);
    }
}
