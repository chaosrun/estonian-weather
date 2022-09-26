<template>
  <div class="home">
    <ForecastList />
    <div id="container">
      <video id="video-bg" preload="auto" autoplay loop muted>
        <source src="https://download.chaos.run/weather/assets/video/bg.mp4" type="video/mp4">
      </video>
    </div>
  </div>
</template>

<script>
import ForecastList from "@/components/ForecastList";

export default {
  name: "HomeView",
  components: {
    ForecastList
  },
  methods: {
  },
};
</script>

<style>
body {
  font-family: "Roboto Mono", monospace;
  color: black;
  background: transparent !important;
}

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
  border: 2px solid black !important;
}

th {
  border-right: 1px solid black !important;
  width: 15%;
}

td {
  white-space: pre-line;
}

#video-bg {
  position: fixed;
  right: 0;
  bottom: 0;
  min-width: 100%;
  min-height: 100%;
  z-index: -99;
  object-fit: cover;
  background: gray;
}
</style>
