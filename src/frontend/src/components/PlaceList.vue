<template>
  <div>
    <div v-for="place in places" :key="place.id">
      <table class="table mt-5" >
        <tr>
          <th>Name</th>
          <td>{{ place.name }}</td>
        </tr>
        <tr>
          <th>Phenomenon</th>
          <td>{{ place.night.phenomenon }}</td>
        </tr>
        <tr>
          <th scope="col" v-if="place.tempMin">Temp Min</th>
          <td>{{ place.night.tempMin }}</td>
        </tr>
        <tr>
          <th scope="col" v-if="place.tempMax">Temp Max</th>
          <td>{{ place.night.tempMax }}</td>
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
      places: [],
    };
  },
  methods: {
  },
  props: ["places"],
};
</script>


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
