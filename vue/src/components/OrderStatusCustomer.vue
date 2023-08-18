<template>
  <div class="container">
    <h1>Enter order ID to view status and details</h1>
    <input class="button-input" type="text" v-model="orderid" />
    <button @click="findOrderDetails" class="button-input button">
      Retrieve Order Details
    </button>
    <table>
      <thead>
        <tr>
          <th>Order Number</th>
          <th>Customer Name</th>
          <th>$ Price</th>
          <th>Pickup Date</th>
          <th>Cake Style</th>
          <th>Cake Size</th>
          <th>Cake Flavor</th>
          <th>Cake Frosting</th>
          <th>Cake Filling</th>
          <th>Order Status</th>
        </tr>
      </thead>
      <tbody>
        <td>{{ order.order_id }}</td>
        <td>{{ order.firstName }} {{ order.lastName }}</td>
        <td>{{ order.totalAmount }}</td>
        <td>{{ order.pickupDate ? formatDate(order.pickupDate) : "" }}</td>
        <td>{{ cake.style }}</td>
        <td>{{ cake.size }}</td>
        <td>{{ cake.flavor }}</td>
        <td>{{ cake.frosting }}</td>
        <td>{{ cake.filling }}</td>
        <td>{{ order.status }}</td>
      </tbody>
    </table>
  </div>
</template>

<script>
import OrderService from "../services/OrderService";
import CakeService from "../services/CakeService";
import { parseISO, format } from "date-fns";

export default {
  data() {
    return {
      orderid: "",
      order: {},
      cake: {},
      listOfOrders: [],
    };
  },
  methods: {
    findOrderDetails() {
      OrderService.getOrder(this.orderid).then((response) => {
        this.order = response.data;
        this.findCakeDetails();
      });
    },
    findCakeDetails() {
      CakeService.getCake(this.order.cake_id).then((response) => {
        this.cake = response.data;
      });
    },
    formatDate(dateStr) {
      const date = parseISO(dateStr);
      return format(date, "MM/dd/yyyy");
    },
  },
};
</script>

<style scoped>
table,
.button,
td,
th {
  font-family: "Poppins", cursive;
  border-collapse: collapse;
  width: 100%;
}

table {
  table-layout: fixed;
}

h1,
th {
  color: rgb(80, 71, 66);
  align-content: center;
  justify-content: center;
  font-family: sans-serif, "Poppins";
}

.button-input,
.container,
h1 {
  width: fit-content;
  margin: 0 auto 0 auto;
}

.button {
  background-color: #4caf50;
  border: none;
  color: white;
  padding: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 12px;
}

th,
td {
  width: calc(100% / 10);
  padding: 8px;
  text-align: left;
  border: 1px solid black;
  background-color: white;
}
</style>