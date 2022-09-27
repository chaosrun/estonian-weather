package run.chaos.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;
import run.chaos.weather.service.ForecastService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    @Autowired
    private ForecastService forecastService;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 600000)
    public void refreshXML() throws ParserConfigurationException, IOException, SAXException {
        forecastService.getForecastByConsumingXMLApi();
        log.info("The latest XML is fetched: {}", dateFormat.format(new Date()));
    }
}
