import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    getCakes() {
        return http.get('/cakes');
    },
    getCake(cake_id){
        return http.get(`/cakes/${cake_id}`)
    },
    placeOrder(order){
        return http.post('/orders/standard', order)
    }
}