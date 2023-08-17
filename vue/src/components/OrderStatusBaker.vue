<template>
  <div>
    <h1>Orders Calendar</h1>
    <full-calendar
      class="calendar"
      :events="fcEvents"
      locale="en"
    ></full-calendar>
    <div class="filter-box">
      <h1>Orders List</h1>
      <label class="style" for="filter">
        Filter Orders by Current Order Status:
      </label>
      <input type="text" v-model="filter" />
    </div>
    <div class="container">
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
          <tr v-for="order in filteredOrders" v-bind:key="order.order_id">
            <td>{{ order.order_id }}</td>
            <td>{{ order.cake_id }}</td>
            <td>{{ order.lastName }}</td>
            <td>{{ order.phoneNumber }}</td>
            <td>{{ order.orderDate ? formatDate(order.orderDate) : "" }}</td>
            <td>{{ order.pickupDate ? formatDate(order.pickupDate) : "" }}</td>
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
        this.populateFcEvents(); // Update fcEvents when order status changes
        this.sortOrders();
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
  this.fcEvents = this.listOfOrders
    .filter(order => order.status === 'Pending')
    .map(order => {
      return {
        title: `Order #${order.order_id}, ${order.lastName}`,
        start: order.pickupDate,
      };
    });
},
  },
   computed: {
    filteredOrders() {
      let filtered = [];

      if (this.filter) {
        filtered = this.listOfOrders.filter((order) =>
          order.status.toLowerCase().includes(this.filter.toLowerCase())
        );
      } else {
        // No filter applied, sort by pickupDate
        filtered = this.listOfOrders.slice().sort((a, b) => {
          const pickupDateA = new Date(a.pickupDate);
          const pickupDateB = new Date(b.pickupDate);
          return pickupDateA - pickupDateB;
        });
      }

      return filtered;
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
  width: 100%; /* Make the table take up full container width */
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
  padding-bottom: 100px;
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

/* Set a fixed width for each cell */
th,
td {
  width: calc(100% / 10); /* Divide by the number of columns */
  padding: 8px;
  text-align: left;
  border: 1px solid black; /* Add this line to set a black border */
  background-color: white;
}
</style>