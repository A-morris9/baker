import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    deleteCake(cake_id) {
        return http.put(`/cakes/delete/${cake_id}`)
    },
    getCakes() {
        return http.get('/cakes');
    },
    getAllCakes() {
        return http.get('/cakes/all');
    },
    getCake(cake_id) {
        return http.get(`/cakes/${cake_id}`)
    },
    placeOrder(order) {
        return http.post('/orders/standard', order)
    },
    placeCustomOrder(order) {
        return http.post('/orders/custom', order)
    },
    getOrder(order_id) {
        return http.get(`/orders/${order_id}`)
    },
    getFlavors() {
        return http.get('/flavors')
    },
    getFrostings() {
        return http.get('/frostings')
    },
    getFillings() {
        return http.get('/fillings')
    },
    changeCakeAvailibility(id) {
        return http.put(`/cakes/availability/${id}`)
    },
    addStandardCake(cake) {
        return http.post('/cakes/standard', cake)
    },
    addCustomCake(cake) {
        return http.post('/cakes/custom', cake)
    }
}