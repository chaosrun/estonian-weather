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
          places: [
            {
              name: null,
              phenomenon: null,
              tempMin: null,
              tempMax: null,
            },
          ],
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
