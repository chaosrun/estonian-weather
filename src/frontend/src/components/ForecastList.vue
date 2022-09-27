<template>
  <div class="it-lists">
    <h1>Weather in Estonia</h1>
    <!-- Tab links -->
    <div class="button-section">
    <div class="button-switch" v-for="(date, index) in dates" :key="index">
      <button @click="replaceFlags(index, 1)">{{ formatDate(date) }} Night</button>
      <button @click="replaceFlags(index, 0)">{{ formatDate(date) }} Day</button>
    </div>
    </div>

    <div class="it-lists-non" v-if="forecasts.length === 0">
      Loading...
    </div>
    <div v-for="(forecast, fIndex) in forecasts" :key="forecast.id">
      
      <table class="table mt-5" v-if="fIndex === index && night === 1">
        <tr>
          <th>Period</th>
          <td>{{ formatDate(forecast.date) }} Night</td>
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
          <td>{{ formatDate(forecast.date) }} Day</td>
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

    <table class="table mt-5 footer">
      <tr>
        <th>Source Code</th>
        <td><a href="https://github.com/chaosrun/estonian-weather" target="_blank">GitHub</a></td>
      </tr>
      <tr>
        <th>Copyright</th>
        <td>{{new Date().getFullYear()}}<a href="https://chaos.run" target="_blank" style="text-decoration: none">Chaos</a></td>
      </tr>
    </table>

  </div>
</template>

<script>
import moment from 'moment'

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
    formatDate(value){
      if (value) {
        return moment(String(value)).format('DD.MM')
      }
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
    h1 {
      font-family: "Roboto", serif;
      text-align: center;
      color: white;
      font-weight: bold;
      font-size: 48px;
    }

    .it-lists {
      color: black;
      max-width: 800px;
      margin: 50px auto auto;
    }

    .it-lists-non {
      text-align: center;
      font-size: 1.5em;
      font-weight: bold;
      color: white;
      margin-top: 30px;
      margin-left: 5px;
    }

    button {
      font-family: "Roboto", serif;
      border: 1px solid white;
      border-radius: 10px;
      background-color: rgba(0, 0, 0, 0.85);
      color: #eaeaea;
    }

    button:hover {
      background: rgba(255, 255, 255, 0.9);
      color: black;
    }

    .button-switch {
      margin: 1rem 0 1rem 0;
      display: inline-flex;
      width: 20%;
    }

    .button-section {
      margin-top: 3rem;
      line-height: 2rem;
    }

    .button-switch button {
      margin-left: 0.5rem;
      margin-right: 0.5rem;
    }

    .footer {
      margin: 60px auto 80px !important;
      width: 40%;
    }

    .footer th {
      width: 40%;
    }

    .footer td {
      text-align: center;
    }

    .footer a {
      color: #d2d2d2;
    }

    @media (max-width: 780px) {
      .button-switch {
        width: unset;
      }
    }

    @media (max-width: 400px) {
      h1 {
        font-size: 32px;
      }
    }
</style>
