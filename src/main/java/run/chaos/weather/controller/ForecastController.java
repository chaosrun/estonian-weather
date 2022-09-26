package run.chaos.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import run.chaos.weather.model.Forecast;
import run.chaos.weather.service.ForecastService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @GetMapping("/forecast")
    public ResponseEntity<List<Forecast>> getForecasts() throws ParserConfigurationException, IOException, SAXException {
        return ResponseEntity.ok().body(forecastService.getForecasts());
    }

    @GetMapping("/forecast/refresh")
    public ResponseEntity<List<Forecast>> refreshForecasts() throws ParserConfigurationException, IOException, SAXException {
        return ResponseEntity.ok().body(forecastService.getForecastByConsumingXMLApi());
    }

    @GetMapping("/forecast/dates")
    public ResponseEntity<List<LocalDate>> getForecastDates() throws ParserConfigurationException, IOException, SAXException {
        return ResponseEntity.ok().body(forecastService.getForecastDates());
    }

    @GetMapping("/forecast/date/{date}")
    public ResponseEntity<Forecast> getForecastByDate(@PathVariable("date") String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        return ResponseEntity.ok().body(forecastService.getForecastByDate(date));
    }

}
