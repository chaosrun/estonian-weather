<template>
  <div class="it-lists">
    <h1>Weather in Estonia</h1>
    <!-- Tab links -->
    <div class="it-lists-non" v-if="forecasts.length === 0">
      No forecasts
    </div>
    <div v-for="forecast in forecasts" :key="forecast.id">
      
      <table class="table mt-5">
        <tr>
          <th>Period</th>
          <td>{{ forecast.date }} Night</td>
        </tr>
        <tr>
          <th>Phenomenon</th>
          <td>{{ forecast.night.phenomenon }}</td>
        </tr>
        <tr>
          <th>Temp Min</th>
          <td>{{ forecast.night.tempMin }}</td>
        </tr>
        <tr>
          <th>Temp Max</th>
          <td>{{ forecast.night.tempMax }}</td>
        </tr>
        <tr>
          <th>Text</th>
          <td>{{ forecast.night.text }}</td>
        </tr>
        <tr v-if="forecast.night.sea">
          <th>Sea</th>
          <td>{{ forecast.night.sea }}</td>
        </tr>
        <tr v-if="forecast.night.peipsi">
          <th>Peipsi</th>
          <td>{{ forecast.night.peipsi }}</td>
        </tr>
      </table>

      <PlaceList :places="forecast.night.places" />

      <table class="table mt-5">
        <tr>
          <th>Period</th>
          <td>{{ forecast.date }} Day</td>
        </tr>
        <tr>
          <th>Phenomenon</th>
          <td>{{ forecast.day.phenomenon }}</td>
        </tr>
        <tr>
          <th>Temp Min</th>
          <td>{{ forecast.day.tempMin }}</td>
        </tr>
        <tr>
          <th>Temp Max</th>
          <td>{{ forecast.day.tempMax }}</td>
        </tr>
        <tr>
          <th>Text</th>
          <td>{{ forecast.day.text }}</td>
        </tr>
        <tr v-if="forecast.day.sea">
          <th>Sea</th>
          <td>{{ forecast.day.sea }}</td>
        </tr>
        <tr v-if="forecast.day.peipsi">
          <th>Peipsi</th>
          <td>{{ forecast.day.peipsi }}</td>
        </tr>
      </table>

      <PlaceList :places="forecast.day.places" />
      
    </div>
  </div>
</template>

<script>
import ForecastService from "../services/ForecastService.js";
import PlaceList from "@/components/PlaceList";

export default {
  name: "ForecastList",
  data() {
    return {
      forecasts: [],
      dates: [],
    };
  },
  methods: {
    getAllForecasts() {
      ForecastService.getForecast().then((response) => {
        this.forecasts = response.data;
      });
    },
    getDates() {
      ForecastService.getForecastDates().then((response) => {
        this.dates = response.data;
      });
    },
  },
  beforeMount() {
    this.getAllForecasts();
  },
  components: {
    PlaceList
  }
};
</script>
