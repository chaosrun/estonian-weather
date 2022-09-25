package run.chaos.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;
import run.chaos.weather.service.ForecastService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Component
public class ScheduledTasks {
    @Autowired
    private ForecastService forecastService;

    @Scheduled(fixedRate = 600000)
    public void refreshXML() throws ParserConfigurationException, IOException, SAXException {
        forecastService.getForecastByConsumingXMLApi();
    }
}
