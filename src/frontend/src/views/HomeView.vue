<template>
  <div class="home">
    <ForecastList />
    <div id="container">
      <video id="video-bg" poster="@/assets/image/bg.jpg" preload="auto" autoplay loop muted>
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
    color: black;
    background: transparent !important;
  }

  table td, table th {
    border-top: 1px solid #5e5e5e !important;
    border-bottom: 1px solid #5e5e5e !important;
  }

  table {
    font-family: "Roboto", serif;
    text-align: left;
    border-radius: 10px;
    border-collapse: collapse;
    border-style:hidden;
    box-shadow: 0 0 0 2px #b0b0b0;
    background-color: rgba(0, 0, 0, 0.9) !important;
    color: #d2d2d2 !important;
  }

  th {
    border-right: 1px solid #b3b3b3 !important;
    width: 15%;
    color: #d2d2d2 !important;
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
    background: #919191;
  }

  @media (max-width: 869px) {
    table {
      width: 90% !important;
      margin: auto;
    }
  }

  @media (max-width: 400px) {
    #video-bg {
      height: 120%;
      bottom: -60px;
    }
  }
</style>
