package run.chaos.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import run.chaos.weather.model.ForecastPeriod;
import run.chaos.weather.repository.ForecastPeriodRepository;

@Service
public class ForecastPeriodService {
    @Autowired
    private ForecastPeriodRepository forecastPeriodRepository;

    public ForecastPeriod addForecastPeriod(ForecastPeriod forecastPeriod) {
        return forecastPeriodRepository.save(forecastPeriod);
    }
}
