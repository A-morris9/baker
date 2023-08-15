<template>
  <div>
    <h1>Space to View Standard Cakes and mark available or unavailable</h1>
    <table>
      <thead>
        <tr>
          <th>Cake ID</th>
          <th>Name</th>
          <th>Cake Availability Status</th>
        </tr>
      </thead>
      <tbody >
        <tr v-for="cake in listOfCakes" v-bind:key="cake.cake_id">
          <td>{{ cake.cake_id }}</td>
          <td>{{ cake.title }}</td>
          <td>{{ getAvailabilityText(cake.availability) }}</td>
          <td>
            <button @click="updateCakeStatus(cake.cake_id)">
              Change Cake Availability
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <div class="divider"></div>
    <table>
      <thead>
        <tr>
          <th>Parameter</th>
          <th>Options</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Cake Name</td>
          <td>
            <input id="cakeName" type="text" v-model="newStandardCake.title" />
          </td>
        </tr>
        <tr>
          <td>Cake Description</td>
          <td>
            <input
              id="cakeDescription"
              type="text"
              v-model="newStandardCake.description"
            />
          </td>
        </tr>
        <tr>
          <td>Cake Style</td>
          <td>
            <label v-for="style in Styles" v-bind:key="style.id">
              <input
                type="radio"
                name="param1"
                :value="style.id"
                v-model="newStandardCake.style"
              />
              {{ style.name }}
            </label>
          </td>
        </tr>
        <tr>
          <td>Flavor</td>
          <td>
            <label v-for="flavor in Flavors" v-bind:key="flavor.flavor_id">
              <input
                type="radio"
                name="param2"
                :value="flavor.flavor_id"
                v-model="newStandardCake.flavor"
              />
              {{ flavor.description }}
            </label>
          </td>
        </tr>
        <tr>
          <td>Frosting</td>
          <td>
            <label
              v-for="frosting in Frostings"
              v-bind:key="frosting.frosting_id"
            >
              <input
                type="radio"
                name="param3"
                :value="frosting.frosting_id"
                v-model="newStandardCake.frosting"
              />
              {{ frosting.description }}
            </label>
          </td>
        </tr>
        <tr>
          <td>Filling</td>
          <td>
            <label v-for="filling in Fillings" v-bind:key="filling.filling_id">
              <input
                type="radio"
                name="param4"
                :value="filling.filling_id"
                v-model="newStandardCake.filling"
              />
              {{ filling.description }}
            </label>
          </td>
        </tr>
        <tr>
          <td>Price</td>
          <td>
            <input id="price" type="text" v-model="newStandardCake.price" />
          </td>
        </tr>
        <tr>
          <td>Image (url)</td>
          <td>
            <input id="cakeImage" type="text" v-model="newStandardCake.image" />
          </td>
        </tr>
        <tr>
          <td>
            <button @click="addStandardCake(newStandardCake)">
              Add New Cake to Standard Offerings
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import CakeService from "../services/CakeService";

export default {
  data() {
    return {
      listOfCakes: [],
      selectedCakeId: null,
      Styles: [
        { id: 1, name: "Layer" },
        { id: 2, name: "Sheet" },
        { id: 3, name: "Cupckaes" },
      ],
      Flavors: [],
      Frostings: [],
      Fillings: [],
      newStandardCake: {
        flavor: 0,
        frosting: 0,
        filling: 0,
        style: 0,
      },
    };
  },
  created() {
    CakeService.getAllCakes().then((response) => {
      this.listOfCakes = response.data;
    });
    CakeService.getFlavors().then((response) => {
      this.Flavors = response.data;
    });
    CakeService.getFrostings().then((response) => {
      this.Frostings = response.data;
    });
    CakeService.getFillings().then((response) => {
      this.Fillings = response.data;
    });
  },
  computed: {
    selectedCakeTitle() {
      const cake = this.listOfCakes.find(
        (cake) => cake.cake_id === this.selectedCakeId
      );
      return cake ? cake.title : "";
    },
    selectedCakeAvailability() {
      const cake = this.listOfCakes.find(
        (cake) => cake.cake_id === this.selectedCakeId
      );
      return cake ? cake.availability : "";
    },
  },
  methods: {
    updateCakeStatus(id) {
       CakeService.changeCakeAvailibility(id).then(() => {
        const cakeToUpdate = this.listOfCakes.find(cake => cake.cake_id === id);
        
        // Toggle the availability status
        cakeToUpdate.availability = !cakeToUpdate.availability;
      });
    },
    getAvailabilityText(Availability) {
      return Availability ? "Available" : "Not Available";
    },
    addStandardCake(newStandardCake) {
      CakeService.addStandardCake(newStandardCake);
    },
  },
};
</script>

<style scoped>



.divider {
  width: 100%;
  height: 1px;
  background-color: rgb(80, 71, 66);
}

.all-actions {
  margin-bottom: 40px;
}

h1,
th {
  font-family: "Big Shoulders Display", cursive;
  color: rgb(80, 71, 66);
}
td {
  font-family: "Poppins", cursive;
  color: rgb(80, 71, 66);
  font-weight: bold;
}
th {
  font-size: 20px;
}
</style>