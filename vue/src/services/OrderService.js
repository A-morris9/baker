import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    getOrder(order_id){
        return http.get(`/orders/${order_id}`)
    },
    getOrders(){
        return http.get('/orders')
    },
    changeOrderStatus(id, newStatus){
        return http.put(`/orders/changeStatus/${id}/${newStatus}`)
    }
}