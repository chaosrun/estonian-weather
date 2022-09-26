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
          <th scope="col">Phenomenon</th>
          <td>{{ forecast.night.phenomenon }}</td>
        </tr>
        <tr>
          <th scope="col">Temp Min</th>
          <td>{{ forecast.night.tempMin }}</td>
        </tr>
        <tr>
          <th scope="col">Temp Max</th>
          <td>{{ forecast.night.tempMax }}</td>
        </tr>
        <tr>
          <th scope="col">Text</th>
          <td>{{ forecast.night.text }}</td>
        </tr>
        <tr v-if="forecast.night.sea">
          <th scope="col">Sea</th>
          <td>{{ forecast.night.sea }}</td>
        </tr>
        <tr v-if="forecast.night.peipsi">
          <th scope="col" v-if="forecast.night.peipsi">Peipsi</th>
          <td>{{ forecast.night.peipsi }}</td>
        </tr>
      </table>

      <table class="table mt-5">
        <tr>
          <th>Period</th>
          <td>{{ forecast.date }} Day</td>
        </tr>
        <tr>
          <th scope="col">Phenomenon</th>
          <td>{{ forecast.day.phenomenon }}</td>
        </tr>
        <tr>
          <th scope="col">Temp Min</th>
          <td>{{ forecast.day.tempMin }}</td>
        </tr>
        <tr>
          <th scope="col">Temp Max</th>
          <td>{{ forecast.day.tempMax }}</td>
        </tr>
        <tr>
          <th scope="col">Text</th>
          <td>{{ forecast.day.text }}</td>
        </tr>
        <tr v-if="forecast.day.sea">
          <th scope="col">Sea</th>
          <td>{{ forecast.day.sea }}</td>
        </tr>
        <tr v-if="forecast.day.peipsi">
          <th scope="col" v-if="forecast.day.peipsi">Peipsi</th>
          <td>{{ forecast.day.peipsi }}</td>
        </tr>
      </table>
      
    </div>
  </div>
</template>

<script>
import ForecastService from "../services/ForecastService.js";
// import PlaceList from "@/components/PlaceList";

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
.it-lists {
  max-width: 800px;
  margin: 50px auto auto;
}

.it-lists-non {
  margin-top: 30px;
  margin-left: 5px;
  font-size: 20px;
  font-weight: 400;
}

table {
  text-align: left;
  border: 2px solid black;
  border-radius: 1px;
}
</style>
