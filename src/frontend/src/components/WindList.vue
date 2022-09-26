<template>
  <div v-if="winds.length > 0">
    <div v-for="wind in winds" :key="wind.id">
      <table class="table mt-5" v-if="wind.name || wind.direction || wind.speedMin || wind.speedMax || wind.gust">
        <tr>
          <th>Wind</th>
          <td>{{ wind.name }}</td>
        </tr>
        <tr>
          <th>direction</th>
          <td>{{ wind.direction }}</td>
        </tr>
        <tr v-if="wind.speedMin !== null">
          <th>speed Min</th>
          <td>{{ wind.speedMin }}</td>
        </tr>
        <tr v-if="wind.speedMax !== null">
          <th>speed Max</th>
          <td>{{ wind.speedMax }}</td>
        </tr>
        <tr v-if="wind.gust !== null">
          <th>Gust</th>
          <td>{{ wind.gust }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "WindList",
  data() {
    return {
    };
  },
  methods: {
  },
  props: {
    winds: {
      type: Array,
      required: true,
    },
  },
};
</script>
