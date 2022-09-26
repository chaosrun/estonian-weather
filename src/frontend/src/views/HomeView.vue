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

<style>
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
</style>
