package run.chaos.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import run.chaos.weather.model.Forecast;
import run.chaos.weather.model.ForecastPeriod;
import run.chaos.weather.model.Place;
import run.chaos.weather.repository.ForecastRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

@Service
public class ForecastService {
    @Autowired
    private ForecastRepository forecastRepository;

    public Forecast addForecast(Forecast forecast) {
        return forecastRepository.save(forecast);
    }

    public Optional<Forecast> updateForecast(LocalDate date, Forecast updatedForecast) {
        return forecastRepository.findByDate(date).map(forecast -> {
            forecast.setNight(updatedForecast.getNight());
            forecast.setDay(updatedForecast.getDay());
            return forecastRepository.save(forecast);
        });
    }

    public List<Forecast> getForecasts() throws ParserConfigurationException, IOException, SAXException {
        // Get four recent forecasts in the database by sorting by date, and then reverse the list
        if (forecastRepository.findAll().size() >= 4) {
            List<Forecast> forecasts = forecastRepository.findAllByOrderByDateDesc().subList(0, 4);
            Collections.reverse(forecasts);
            return forecasts;
        } else {
            return getForecastByConsumingXMLApi();
        }
    }

    public List<Forecast> getForecastByConsumingXMLApi() throws ParserConfigurationException, IOException, SAXException {
        List<Forecast> forecasts = new java.util.ArrayList<>(List.of());

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/test/resources/test.xml"));
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("forecast");

        // Loop through the forecast nodes using getForecastFromNode
        for (int i = 0; i < nodeList.getLength(); i++) {
            Forecast forecast = getForecastFromNode(nodeList.item(i));
            if (forecastRepository.findByDate(forecast.getDate()).isEmpty()) {
                forecast = addForecast(forecast);
            } else {
                forecast = updateForecast(forecast.getDate(), forecast).orElse(forecast);
            }
            forecasts.add(forecast);
        }

        return forecasts;
    }

    public Forecast getForecastFromNode(Node node) {
        Forecast forecast = new Forecast();
        forecast.setDate(LocalDate.parse(node.getAttributes().getNamedItem("date").getNodeValue()));
        Element eRoot = (Element) node;
        Node nightNode = eRoot.getElementsByTagName("night").item(0);
        Node dayNode = eRoot.getElementsByTagName("day").item(0);
        forecast.setNight(getForecastPeriodFromNode(nightNode));
        forecast.setDay(getForecastPeriodFromNode(dayNode));
        return forecast;
    }

    public ForecastPeriod getForecastPeriodFromNode(Node node) {
        ForecastPeriod forecastPeriod = new ForecastPeriod();
        Element eRoot = (Element) node;
        forecastPeriod.setPhenomenon(eRoot.getElementsByTagName("phenomenon").item(0).getTextContent());
        forecastPeriod.setTempMin(Integer.parseInt(eRoot.getElementsByTagName("tempmin").item(0).getTextContent()));
        forecastPeriod.setTempMax(Integer.parseInt(eRoot.getElementsByTagName("tempmax").item(0).getTextContent()));
        forecastPeriod.setText(eRoot.getElementsByTagName("text").item(0).getTextContent());
        Node sea = eRoot.getElementsByTagName("sea").item(0);
        if (sea != null) {
            forecastPeriod.setSea(sea.getTextContent());
        }
        Node peipsi = eRoot.getElementsByTagName("peipsi").item(0);
        if (peipsi != null) {
            forecastPeriod.setPeipsi(peipsi.getTextContent());
        }
        NodeList places = eRoot.getElementsByTagName("place");
        forecastPeriod.setPlaces(getPlacesFromNodeList(places));
        NodeList winds = eRoot.getElementsByTagName("wind");
        return forecastPeriod;
    }

    public List<Place> getPlacesFromNodeList(NodeList nodes) {
        List<Place> places = new java.util.ArrayList<>(List.of());
        for (int i = 0; i < nodes.getLength(); i++) {
            Place place = new Place();
            Element eRoot = (Element) nodes.item(i);
            place.setName(eRoot.getElementsByTagName("name").item(0).getTextContent());
            place.setPhenomenon(eRoot.getElementsByTagName("phenomenon").item(0).getTextContent());
            Node tempMin = eRoot.getElementsByTagName("tempmin").item(0);
            if (tempMin != null) {
                place.setTempMin(Integer.parseInt(tempMin.getTextContent()));
            }
            Node tempMax = eRoot.getElementsByTagName("tempmax").item(0);
            if (tempMax != null) {
                place.setTempMax(Integer.parseInt(tempMax.getTextContent()));
            }
            places.add(place);
        }
        return places;
    }
}
