<template>
  <div>
    <h1>Orders Calendar</h1>
    <full-calendar class="calendar" :events="fcEvents" locale="en"></full-calendar>
    <h1>Orders List</h1>
    <label class="style" for="filter">
      Filter Orders by Current Order Status:
    </label>
    <input type="text" v-model="filter" />
    <div class="container">
      <table>
        <thead>
          <tr>
            <th>Order ID </th>
            <th>Cake ID </th>
            <th>Last Name </th>
            <th>Phone Number </th>
            <th>Order Date </th>
            <th>Pick-Up Date </th>
            <th>Writing </th>
            <th>Price </th>
            <th>Phone Number </th>
            <th>Current Order Status </th>
            <th>Change Order Status</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="order in filteredOrders" v-bind:key="order.order_id">
            <td>{{ order.order_id }}</td>
            <td>{{ order.cake_id }}</td>
            <td>{{ order.lastName }}</td>
            <td>{{ order.phoneNumber }}</td>
            <td>{{ order.orderDate ? formatDate(order.orderDate) : ""  }}</td>
            <td>{{ order.pickupDate ? formatDate(order.pickupDate) : ""  }}</td>
            <td>{{ order.writing }}</td>
            <td>{{ order.totalAmount }}</td>
            <td>{{ order.phoneNumber }}</td>
            <td>{{ order.status }}</td>
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
  </div>
</template>

<script>
import OrderService from "../services/OrderService";
import { parseISO, format } from "date-fns";

let events = [
  {
    title: "We got cakes",
    start: "2023-08-25",
    end: "2023-08-27",
  },
];

export default {
  data() {
    return {
      fcEvents: events,
      filter: "",
      listOfOrders: [],
    };
  },
  components: {
    "full-calendar": require("vue-fullcalendar"),
  },
  created() {
    OrderService.getOrders().then((response) => {
      this.listOfOrders = response.data;
      this.populateFcEvents();
      this.sortOrders();
    });
  },
  methods: {
    updateOrderStatus(order, newStatus) {
      OrderService.changeOrderStatus(order.order_id, newStatus).then(() => {
        order.status = newStatus;
      });
    },
    sortOrders() {
      this.listOfOrders.sort((a, b) => a.order_id - b.order_id);
    },
    formatDate(dateStr) {
      const date = parseISO(dateStr);
      return format(date, "MM/dd/yyyy");
    },
    populateFcEvents() {
      this.fcEvents = this.listOfOrders.map((order) => {
        return {
          title: `Order #${order.order_id}, ${order.lastName}`,
          start: order.pickupDate // Assuming orderDate is in a valid format
           // Assuming pickupDate is in a valid format
        };
      });
    },
  },
  computed: {
    filteredOrders() {
      if (this.filter) {
        return this.listOfOrders.filter((order) =>
          order.status.toLowerCase().includes(this.filter.toLowerCase())
        );
      } else return this.listOfOrders.slice().sort((a, b) => {
        const pickupDateA = new Date(a.pickupDate);
        const pickupDateB = new Date(b.pickupDate);
        return pickupDateA - pickupDateB;
      });
    },
  },
};
</script>

<style scoped>
h1,
th, label {
  font-family: "Big Shoulders Display", cursive;
  color: rgb(80, 71, 66);
  font-size: 20;
}
th {
  font-size: 20px;
}
.all-actions {
  margin-bottom: 40px;
}

.style {
  color: rgb(80, 71, 66);
}
.container {
  display: flex;
  justify-content: center;
  width: 100%;
  height: 100vh;
  margin: 0 auto 0 auto;
}
th, td {
  border: 1px solid black;
  padding: 8px;
  text-align: left;
  font-size: 25px;
  
}
table{
  background-color: #4caf4fa7;
  width: 90%;
}
.calendar{
  max-width: 88%;
  font-size: 20px;

}
</style>