# Weather Forecast in Estonia

This is a weather forecast web app for Estonia. It uses the [Estonian Environment Agency XML Service](https://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng) to fetch the weather data.

## Installation

### Using Docker

First, clone the repository:

```bash
git clone git@github.com:chaosrun/estonian-weather.git
```

Then, enter the directory and edit the `.env` file to set environment variables:

```bash
cd estonian-weather
mv .env.example .env
vim .env
```

Finally, run the Docker container:

```bash
docker-compose up -d
```

The web app will be available at `http://localhost:{SERVER_PORT}`.

## Development

### Justification

The application will not re-fetch the online XML file every time a user accesses the forecast page, because frequent consumption of XML is unnecessary and increases latency. The program fetches the data from the online XML every 10 minutes and updates the data to the database.

### Tech Stack

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Vue.js](https://vuejs.org/)
- [PostgreSQL](https://www.postgresql.org/)

### Modelling

Below is a class diagram of the backend.

![Class diagram of Backend](docs/backend-classes.png)

### Endpoints

| URI                        | METHOD | DESCRIPTION                                                                                  |
|----------------------------|--------|----------------------------------------------------------------------------------------------|
| /api/forecast              | GET    | Get forecasts for next 4-days                                                                |
| /api/forecast/date/{date}  | GET    | Get day and night forecast by specifying a date (can retrieve history forecasts in database) |
| /api/forecast/night/{date} | GET    | Get night forecast by specifying a date                                                      |
| /api/forecast/day/{date}   | GET    | Get day forecast by specifying a date                                                        |

### Database

The app uses a PostgreSQL database. You can create the development database with the following commands:

```bash
sudo -u postgres psql
```

```sql
create database ootdb;
create user oot with encrypted password 'oot';
grant all privileges on database ootdb to oot;
```

## License

[Gnu General Public License v3.0](LICENSE)
