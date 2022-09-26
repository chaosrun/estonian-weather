<template>
  <div class="forecast">
    <h1>Forecast Details</h1>

    <table class="table mt-5">
      <tr>
        <th>Date:</th>
        <td>{{ forecast.date }}</td>
      </tr>
      <tr>
        <th>Material Title:</th>
        <td>{{ forecast.date }}</td>
      </tr>
      <tr>
        <th>Material:</th>
        <td>{{ forecast.date }}</td>
      </tr>
      <tr>
        <th>Material Home Library:</th>
        <td>{{ forecast.date }}</td>
      </tr>
      <tr>
        <th>Start Date:</th>
        <td>{{ forecast.date }}</td>
      </tr>
      <tr>
        <th>End Date:</th>
        <td>{{ forecast.date }}</td>
      </tr>
      <tr>
        <th>Status:</th>
        <td>{{ forecast.status }}</td>
      </tr>
      <tr>
        <th>User Name:</th>
        <td>{{ forecast.date }}</td>
      </tr>
      <tr>
        <th>User Email:</th>
        <td>{{ forecast.date }}</td>
      </tr>
      <tr>
        <th>Location Address:</th>
        <td>{{ forecast.date }}</td>
      </tr>
      <tr>
        <th>Location City:</th>
        <td>{{ forecast.date }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import ForecastService from "../services/ForecastService.js";

export default {
  name: "ForecastUnit",
  data() {
    return {
      forecast: {
        date: null,
        night: {
          phenomenon: null,
          tempMin: null,
          tempMax: null,
          text: null,
          sea: null,
          peipsi: null,
          places: [],
          winds: []
        },
        day: {
          phenomenon: null,
          tempMin: null,
          tempMax: null,
          text: null,
          sea: null,
          peipsi: null,
          places: [],
          winds: []
        }
      },
      dates: [],
    };
  },
  methods: {
    get(date) {
      ForecastService.getForecastByDate(date)
          .then((response) => {
            this.forecast = response.data;
          })
          .catch((error) => {
            console.log(error);
            alert("Error: " + error);
          });
    },
    getDates() {
      ForecastService.getForecastDates()
          .then((response) => {
            this.dates = response.data;
          })
          .catch((error) => {
            console.log(error);
            alert("Error: " + error);
          });
    },
  },
  beforeMount() {
    this.get(this.$route.params.date);
  },
};
</script>

<style scoped>
.forecast {
  max-width: 800px;
  margin: 50px auto auto;
}

tr {
  border-color: #ccc !important;
}
</style>