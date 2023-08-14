<template>
 <div>
  <h1>this is an order list page for bakers only</h1>
  <table>
      <thead>
        <tr>
          <th> Order ID |</th> 
          <th> Cake ID |</th> 
          <th> Last Name |</th> 
          <th> Phone Number |</th> 
          <th> Order Date |</th> 
          <th> Pick-Up Date |</th> 
          <th> Writing |</th> 
          <th> Price |</th> 
          <th> Phone Number |</th> 
          <th> Current Order Status |</th> 
          <th> Change Order Status </th>
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
                <select @change="updateOrderStatus(order, $event.target.value)">
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
 </div> 
</template>

<script>
import OrderService from "../services/OrderService";

export default {
    data() {
    return {
        listOfOrders : [],
    }
    },
    created() {
        OrderService.getOrders().then((response) => {
            this.listOfOrders = response.data;
            this.sortOrders();
        })
        
    },
    methods:{
      updateOrderStatus(order, newStatus) {
          OrderService.changeOrderStatus(order.order_id, newStatus).then(() => {
            order.status = newStatus;
          })
          },
      sortOrders() {
        this.listOfOrders.sort((a,b) => a.order_id - b.order_id);
      }    
          },
    } 

  
</script>

<style scoped>
h1, th {
  font-family: 'Big Shoulders Display', cursive;
  color: rgb(80, 71, 66);
}
th {
  font-size: 20px;
}
.all-actions {
  margin-bottom: 40px;
}

</style>