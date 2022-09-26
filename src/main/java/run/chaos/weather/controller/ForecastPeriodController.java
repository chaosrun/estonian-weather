package run.chaos.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import run.chaos.weather.exception.DateInvalidException;
import run.chaos.weather.model.ForecastPeriod;
import run.chaos.weather.service.ForecastPeriodService;

import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ForecastPeriodController {

    @Autowired
    private ForecastPeriodService forecastPeriodService;

    @GetMapping("/forecast/night/{date}")
    public ResponseEntity<ForecastPeriod> getNightForecastByDate(@PathVariable("date") String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr);
            return ResponseEntity.ok().body(forecastPeriodService.getNightForecastByDate(date));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/forecast/day/{date}")
    public ResponseEntity<ForecastPeriod> getDayForecastByDate(@PathVariable("date") String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr);
            return ResponseEntity.ok().body(forecastPeriodService.getDayForecastByDate(date));
        } catch (Exception e) {
            throw new DateInvalidException("Date is invalid");
        }
    }

}
