import axios from 'axios';

export default axios.create({
    baseURL: "https://weather.chaos.run/api",
    headers: {
        "content-type": "application/json",
    }
});
