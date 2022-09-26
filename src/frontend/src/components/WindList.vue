<template>
  <div class="it-lists">
    <h1>Weather in Estonia</h1>
    <!-- Tab links -->
    <div class="it-lists-non" v-if="forecasts.length === 0">
      No forecasts
    </div>
    <table v-for="forecast in forecasts" :key="forecast.date" class="table mt-5">
      <thead>
      <tr>
        <th scope="col">Period</th>
        <th scope="col">Phenomenon</th>
        <th scope="col">Temp Min</th>
        <th scope="col">Temp Max</th>
        <th scope="col">Text</th>
        <th scope="col" v-if="forecast.night.sea || forecast.day.sea">Sea</th>
        <th scope="col" v-if="forecast.night.peipsi || forecast.day.peipsi">Peipsi</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <th scope="row">{{ forecast.date }} Night</th>
        <td>{{ forecast.night.phenomenon }}</td>
        <td>{{ forecast.night.tempMin }}</td>
        <td>{{ forecast.night.tempMax }}</td>
        <td>{{ forecast.night.text }}</td>
        <td v-if="forecast.night.sea || forecast.day.sea">{{ forecast.night.sea }}</td>
        <td v-if="forecast.night.peipsi || forecast.day.peipsi">{{ forecast.night.peipsi }}</td>
      </tr>
      <tr>
        <th scope="row">{{ forecast.date }} Day</th>
        <td>{{ forecast.day.phenomenon }}</td>
        <td>{{ forecast.day.tempMin }}</td>
        <td>{{ forecast.day.tempMax }}</td>
        <td>{{ forecast.day.text }}</td>
        <td v-if="forecast.night.sea || forecast.date.sea">{{ forecast.day.sea }}</td>
        <td v-if="forecast.night.peipsi || forecast.date.peipsi">{{ forecast.day.peipsi }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

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
</style>
