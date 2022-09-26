<template>
  <div class="it-lists">
    <h1>Weather in Estonia</h1>
    <!-- Tab links -->
    <div class="button-section">
    <div class="button-switch" v-for="(date, index) in dates" :key="index">
      <button @click="replaceFlags(index, 1)">{{ date }} Night</button>
      <button @click="replaceFlags(index, 0)">{{ date }} Day</button>
    </div>
    </div>

    <div class="it-lists-non" v-if="forecasts.length === 0">
      No forecasts
    </div>
    <div v-for="(forecast, fIndex) in forecasts" :key="forecast.id">
      
      <table class="table mt-5" v-if="fIndex === index && night === 1">
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

      <PlaceList :places="forecast.night.places" v-if="fIndex === index && night === 1"/>
      <WindList :winds="forecast.day.winds" v-if="fIndex === index && night === 1"/>

      <table class="table mt-5" v-if="fIndex === index && night === 0">
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

      <PlaceList :places="forecast.day.places" v-if="fIndex === index && night === 0"/>
      <WindList :winds="forecast.day.winds" v-if="fIndex === index && night === 0"/>
      
    </div>
  </div>
</template>

<script>
import ForecastService from "../services/ForecastService.js";
import PlaceList from "@/components/PlaceList";
import WindList from "@/components/WindList";

export default {
  name: "ForecastList",
  data() {
    return {
      forecasts: [],
      dates: [],
      index: 0,
      night: 1,
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
    replaceFlags(index, night) {
      this.index = index;
      this.night = night;
    },
  },
  beforeMount() {
    this.getAllForecasts();
    this.getDates();
  },
  components: {
    PlaceList,
    WindList,
  },
};
</script>

<style scoped>
    .button-switch {
      flex-direction: row;
      margin: 1rem 0.5rem 1rem 0.5rem;
    }
    .button-section {
      margin-top: 3rem;
    }
    .button-switch button {
      margin-left: 0.5rem;
      margin-right: 0.5rem;
    }
</style>