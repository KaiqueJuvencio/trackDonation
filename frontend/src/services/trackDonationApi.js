import axios from 'axios';

const trackDonationApi = axios.create({
    baseURL: 'http://localhost:8080'
})

export default trackDonationApi;