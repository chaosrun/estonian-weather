package run.chaos.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;
import run.chaos.weather.model.Forecast;
import run.chaos.weather.service.ForecastService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
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

}
