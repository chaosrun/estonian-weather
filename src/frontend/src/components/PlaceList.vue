<template>
  <div v-if="places.length > 0">
    <div v-for="place in places" :key="place.id">
      <table class="table mt-5" v-if="place.name || place.phenomenon || place.tempMin || place.tempMax">
        <tr>
          <th>Place</th>
          <td>{{ place.name }}</td>
        </tr>
        <tr>
          <th>Phenomenon</th>
          <td>{{ place.phenomenon }}</td>
        </tr>
        <tr v-if="place.tempMin !== null">
          <th>Temp Min</th>
          <td>{{ place.tempMin }}</td>
        </tr>
        <tr v-if="place.tempMax !== null">
          <th>Temp Max</th>
          <td>{{ place.tempMax }}</td>
        </tr>
      </table>
    </div>
  </div>

</template>

<script>
export default {
  name: "PlaceList",
  data() {
    return {
    };
  },
  methods: {
  },
  props: {
    places: {
      type: Array,
      required: true,
    },
  },
};
</script>
