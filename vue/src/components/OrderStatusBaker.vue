<template>
 <div>
  <h1>this is an order list page for bakers only</h1>
  <table>
      <thead>
        <tr>
          <th>Order ID</th>
          <th>Cake ID</th>
          <th>Last Name</th>
          <th>Phone Number</th>
          <th>Order Date</th>
          <th>Pick-Up Date</th>
          <th>Writing</th>
          <th>Price</th>
          <th>Phone Number</th>
          <th>Current Order Status</th>
          <th>Change Order Status</th>
        </tr>
      </thead>
      <tbody> 
         <tr v-for="order in listOfOrders" v-bind:key="order.order_id"> 
              <td>{{order.order_id}}</td>  
              <td>{{order.cake_id}}</td>
              <td>{{order.lastName}}</td>
              <td>{{order.phoneNumber}}</td>
              <td>{{order.orderDate}}</td>
              <td>{{order.pickupDate}}</td>
              <td>{{order.writing}}</td>
              <td>{{order.totalAmount}}</td>
              <td>{{order.phoneNumber}}</td>
              <td>{{order.status}}</td>
              <td>
                <select @change="updateOrderStatus(order.order_id, $event.target.value)">
                 <option value="">Select Status</option>
                 <option value="Pending">Pending</option>
                 <option value="Canceled">Canceled</option>
                 <option value="Ready">Ready</option>
                 <option value="Complete">Complete</option>
                </select>
              </td>
         </tr>
      </tbody>
    </table>
    <table>
      <thead>
        <tr>
          <th>Cake ID</th>
          <th>Cake Availability Status</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="cake in listOfCakes" v-bind:key="cake.cake_id">
          <td>{{cake.cake_id}}</td>
          <td>{{getAvailabilityText(cake.Availability)}}</td>
          <td>
                <button @click="updateCakeStatus(cake.cake_id)">Change Cake Availability</button>
          </td>
        </tr>  
      </tbody>    
    </table>    
 </div> 
</template>

<script>
import CakeService from '../services/CakeService';
import OrderService from "../services/OrderService";

export default {
    data() {
    return {
        listOfOrders : [],
        listOfCakes : []
    }
    },
    created() {
        OrderService.getOrders().then((response) => {
            this.listOfOrders = response.data
        })
        CakeService.getCakes().then((response) => {
          this.listOfCakes = response.data
        })
    },
    methods:{
      updateOrderStatus(id, newStatus) {
          OrderService.changeOrderStatus(id, newStatus).then(window.location.reload())
          },
      
      updateCakeStatus(id) {
        CakeService.changeCakeAvailibility(id)
        this.toggleStatus
      },
       getAvailabilityText(Availability) {
        return Availability ? 'Not Available' : 'Available';
      },
      toggleStatus(){
        this.cake.Availability = (this.cake.Availability === 'available') ? 'not available' : 'available'
      }
          
          },
    } 

  
</script>

<style>

.all-actions {
  margin-bottom: 40px;
}

</style>