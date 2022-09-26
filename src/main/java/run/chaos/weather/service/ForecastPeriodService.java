package run.chaos.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import run.chaos.weather.exception.ResourceNotFoundException;
import run.chaos.weather.model.Forecast;
import run.chaos.weather.model.ForecastPeriod;
import run.chaos.weather.repository.ForecastPeriodRepository;
import run.chaos.weather.repository.ForecastRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ForecastPeriodService {
    @Autowired
    private ForecastPeriodRepository forecastPeriodRepository;

    @Autowired
    private ForecastRepository forecastRepository;

    public ForecastPeriod addForecastPeriod(ForecastPeriod forecastPeriod) {
        return forecastPeriodRepository.save(forecastPeriod);
    }

    public ForecastPeriod getNightForecastByDate(LocalDate date) {
        Optional<Forecast> forecast = forecastRepository.findByDate(date);
        if (forecast.isPresent()) {
            return forecast.get().getNight();
        } else {
            throw new ResourceNotFoundException("Forecast not found for date: " + date);
        }
    }

    public ForecastPeriod getDayForecastByDate(LocalDate date) {
        Optional<Forecast> forecast = forecastRepository.findByDate(date);
        if (forecast.isPresent()) {
            return forecast.get().getDay();
        } else {
            throw new ResourceNotFoundException("Forecast not found for date: " + date);
        }
    }

}
