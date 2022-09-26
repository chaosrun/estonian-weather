import http from "../http-common";

class ForecastService {
    getForecast() {
        return http.get("/forecast");
    }
    getForecastDates() {
        return http.get("/forecast/dates");
    }
    getForecastByDate(date) {
        return http.get(`/forecast/date/${date}`);
    }
    getForecastNightByDate(date) {
        return http.get(`/forecast/night/${date}`);
    }
    getForecastDayByDate(date) {
        return http.get(`/forecast/day/${date}`);
    }
}

export default new ForecastService();
