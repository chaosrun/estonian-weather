<template>
  <div>
    <div v-for="place in places" :key="place.id">
      <table class="table mt-5" v-if="place">
        <tr>
          <th>Name</th>
          <td>{{ place.name }}</td>
        </tr>
        <tr>
          <th>Phenomenon</th>
          <td>{{ place.phenomenon }}</td>
        </tr>
        <tr>
          <th scope="col" v-if="place.tempMin !== null">Temp Min</th>
          <td>{{ place.tempMin }}</td>
        </tr>
        <tr>
          <th scope="col" v-if="place.tempMax !== null">Temp Max</th>
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
