<template>
  <div class="centered-content">
    <h1> Thank You For Placing Your Order</h1>
    <h2> Feel free to track your order progress by entering your order number on our home page</h2>
    <table>
      <thead>
        <tr class="style">
          <th>Order Number</th>
          <th>Customer Name</th>
          <th>Pickup Date</th>
        </tr>
      </thead>
      <tbody>
          <td>{{order.order_id}}</td>
          <td>{{order.firstName}} {{order.lastName}}</td>
          <td>{{order.pickupDate}}</td>
      </tbody>
    </table>      
  </div>  
</template>

<script>
import CakeService from '../services/CakeService'
export default {
  data() {
    return {
     order : {}
  
    }
  },
  created() {
    CakeService.getOrder(this.$route.params.orderid).then((response) => {
      this.order=response.data;})}
  //  CakeService.getCake(this.order.cake_id).then((response) => {
    //  this.cake=response.data;
    }  
    
</script>

<style>

body {
  background-image: url('../assets/Background.png');
}

.centered-content {
  text-align: center;
}
h1{
  font-family: 'Big Shoulders Display', cursive;
}
h2, .style {
  font-family: 'Poppins', cursive;
}
</style>