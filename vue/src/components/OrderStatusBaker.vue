<template>
 <div>
  <h1>this is an order status page</h1>
  <input type="text" v-model="orderid"/>
  <button @click="findOrderDetails" class="button">Retrieve Order Details</button>
  <table>
      <thead>
        <tr>
          <th>Order Number</th>
          <th>Customer Name</th>
          <th>Pickup Date</th>
          <th>Cake Style</th>
          <th>Cake Size</th>
          <th>Cake Flavor</th>
          <th>Cake Frosting</th>
          <th>Cake Filling</th>
        </tr>
      </thead>
      <tbody>
          <td>
              <label v-for="order in listOfOrders" v-bind:key="order.order_id"></label>
          </td>
      </tbody>
    </table>   
 </div> 
</template>

<script>
import OrderService from "../services/OrderService";
import CakeService from "../services/CakeService";

export default {
    data() {
    return {
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
        findOrderDetails() {
        OrderService.getOrder(this.orderid).then((response) => {
            this.order = response.data
            this.findCakeDetails();
        })},
        findCakeDetails() {
        CakeService.getCake(this.order.cake_id).then((response) => {
            this.cake = response.data
        }) 
        }
    } 

    }
</script>

<style>

</style>