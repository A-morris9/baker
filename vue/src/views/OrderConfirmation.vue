<template>
  <div>
    <bare-bones-header />
    <div class="centered-content">
      <h1>Thank You For Placing Your Order</h1>
      <h2>
        Feel free to track your order progress by entering your order number on
        our home page
      </h2>
    </div>
    <div class="table-container">
      <table>
        <thead>
          <tr class="style">
            <th>Order Number</th>
            <th>Customer Name</th>
            <th>Pickup Date</th>
          </tr>
        </thead>
        <tbody>
          <td>{{ order.order_id }}</td>
          <td>{{ order.firstName }} {{ order.lastName }}</td>
          <td>{{ order.pickupDate ? formatDate(order.pickupDate) : "" }}</td>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import BareBonesHeader from "../components/BareBonesHeader.vue";
import CakeService from "../services/CakeService";
import { parseISO, format } from "date-fns";
export default {
  components: { BareBonesHeader },
  data() {
    return {
      order: {},
    };
  },
  methods: {
    formatDate(dateStr) {
      const date = parseISO(dateStr);
      return format(date, "MM/dd/yyyy");
    },
  },
  created() {
    CakeService.getOrder(this.$route.params.orderid).then((response) => {
      this.order = response.data;
    });
  },
  //  CakeService.getCake(this.order.cake_id).then((response) => {
  //  this.cake=response.data;
};
</script>

<style>
body {
  background-image: url("../assets/Background.png");
}
</style>

<style scoped>
.centered-content {
  text-align: center;
}
h1,
th {
  font-family: "Big Shoulders Display", cursive;
  color: rgb(80, 71, 66);
  font-size: 30px;
}
h2,
td {
  font-family: "Poppins", cursive;
  color: rgb(80, 71, 66);
  font-size: 20px;
}
.table-container {
  display: flex;
  justify-content: center;
}
</style>