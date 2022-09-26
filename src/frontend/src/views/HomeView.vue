<template>
  <div class="home">
    <ForecastList />
  </div>
</template>

<script>
import ForecastList from "@/components/ForecastList";

export default {
  name: "HomeView",
  components: {
    ForecastList,
  },
  methods: {
  },
};
</script>
