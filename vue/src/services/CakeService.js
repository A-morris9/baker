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
    },
    getOrder(order_id){
        return http.get(`/orders/${order_id}`)
    },
    getFlavors(){
        return http.get('/cakes/flavors')
    },
    getFrostings(){
        return http.get('/cakes/frostings')
    },
    changeCakeAvailibility(id) {
        return http.put(`/cakes/availability/${id}`)
    }
}