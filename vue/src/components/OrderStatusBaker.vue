<template>
 <div>
  <h1>this is an order list page for bakers only</h1>
  <table>
      <thead>
        <tr>
          <th>Order ID</th>
          <th>Cake ID</th>
          <th>Last Name</th>
          <th>Phone Number/th>
          <th>Order Date</th>
          <th>Pick-Up Date</th>
          <th>Writing</th>
          <th>Price</th>
          <th>Phone Number</th>
          <th>Status</th>
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
                <input type="checkbox" v-bind:value="order.order_id" v-model="boxChecked" />
              </td>
         </tr>
      </tbody>
    </table>
    <div class="all-actions">
      <button @click="MarkAsCompleted(boxChecked)">Complete Orders</button>
      <button @click="DeleteCanceled(boxChecked)">Cancel Orders</button>
    </div>   
 </div> 
</template>

<script>
import OrderService from "../services/OrderService";

export default {
    data() {
    return {
        boxChecked : [],
        orderid: "",
        order : {},
        cake : {},
        listOfOrders : []
    }
    },
    created() {
        OrderService.getOrders().then((response) => {
            this.listOfOrders = response.data
        })
    },
    methods:{
      MarkAsCompleted(boxChecked) {
          OrderService.changeToComplete(boxChecked) 
          //create method in OrderService to shoot the boxChecked array to the backend to update the status of all of the array's orders
          },
    } 

    }
</script>

<style>

.all-actions {
  margin-bottom: 40px;
}

</style>