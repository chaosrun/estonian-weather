<template>
  <div class="forecasts">
    <h1>Weather in Estonia</h1>
    <!-- Tab links -->
    <div class="forecasts-non" v-if="forecasts.length === 0">
      No forecasts
    </div>
    <table class="table mt-5" v-if="forecasts.length > 0">
      <thead>
      <tr>
        <th scope="col">Period</th>
        <th scope="col">Phenomenon</th>
        <th scope="col">Temp Min</th>
        <th scope="col">Temp Max</th>
        <th scope="col">Text</th>
        <th scope="col">Sea</th>
        <th scope="col">Peipsi</th>
      </tr>
      </thead>
      <tbody v-for="forecast in forecasts" :key="forecast.date">
      <tr>
        <th scope="row">{{ forecast.date }} Night</th>
        <td>{{ forecast.night.phenomenon }}</td>
        <td>{{ forecast.night.tempMin }}</td>
        <td>{{ forecast.night.tempMax }}</td>
        <td>{{ forecast.night.text }}</td>
        <td>{{ forecast.night.sea }}</td>
        <td>{{ forecast.night.peipsi }}</td>
      </tr>
      <tr>
        <th scope="row">{{ forecast.date }} Day</th>
        <td>{{ forecast.day.phenomenon }}</td>
        <td>{{ forecast.day.tempMin }}</td>
        <td>{{ forecast.day.tempMax }}</td>
        <td>{{ forecast.day.text }}</td>
        <td>{{ forecast.day.sea }}</td>
        <td>{{ forecast.day.peipsi }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ForecastService from "../services/ForecastService.js";

export default {
  name: "ForecastList",
  data() {
    return {
      forecasts: []
    };
  },
  methods: {
    getAllForecasts() {
      ForecastService.getForecast().then((response) => {
        this.forecasts = response.data;
      });
    },
  },
  beforeMount() {
    this.getAllForecasts();
  },
};
</script>

<style scoped>
.forecasts {
  max-width: 800px;
  margin: 50px auto auto;
}

.forecasts-non {
  margin-top: 30px;
  margin-left: 5px;
  font-size: 20px;
  font-weight: 400;
}
</style>
