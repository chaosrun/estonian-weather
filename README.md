# Weather Forecast in Estonia

This is a weather forecast web app for Estonia. It uses the [Estonian Environment Agency XML Service](https://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng) to fetch the weather data.

## Development

### Justification

The application will not re-fetch the online XML file every time a user accesses the forecast page, because frequent consumption of XML is unnecessary and increases latency. The program fetches the data from the online XML every 10 minutes and updates the data to the database.

### Tech Stack

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Vue.js](https://vuejs.org/)

### Modelling

Below is a class diagram of the backend.

![Class diagram of Backend](docs/backend-classes.png)

### Endpoints

| URI                    | METHOD | DESCRIPTION                                                                                  |
|------------------------|--------|----------------------------------------------------------------------------------------------|
| /forecast              | GET    | Get forecasts for next 4-days                                                                |
| /forecast/date/{date}  | GET    | Get day and night forecast by specifying a date (can retrieve history forecasts in database) |
| /forecast/night/{date} | GET    | Get night forecast by specifying a date                                                      |
| /forecast/day/{date}   | GET    | Get day forecast by specifying a date                                                        |

## License

[Gnu General Public License v3.0](LICENSE)
