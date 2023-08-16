<template>
  <div class="container">
    <h1>List of all cakes</h1>
    <div class="table-container">
      <table>
        <thead>
          <tr>
            <th>Cake ID</th>
            <th>Name</th>
            <th>Cake Availability Status</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cake in listOfCakes" v-bind:key="cake.cake_id">
            <td>{{ cake.cake_id }}</td>
            <td>{{ cake.title }}</td>
            <td>{{ getAvailabilityText(cake.availability) }}</td>
            <td>
              <button class="button" @click="updateCakeStatus(cake.cake_id)">
                Change Cake Availability
              </button>
              <button class="button" @click="deleteCake(cake.cake_id)">
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="divider"></div>
    <h1>Create a new standard cake</h1>
    <div class="table-container">
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
              <input
                id="cakeName"
                type="text"
                v-model="newStandardCake.title"
              />
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
              <div class="dropdown-container">
                <select v-model="newStandardCake.style">
                  <option value="" disabled>Select a style</option>
                  <option
                    v-for="style in Styles"
                    :key="style.id"
                    :value="style.id"
                  >
                    {{ style.name }}
                  </option>
                </select>
              </div>
            </td>
          </tr>
          <tr></tr>
          <tr>
            <td>Flavor</td>
            <td>
              <div class="dropdown-container">
                <select v-model="newStandardCake.flavor">
                  <option value="" disabled>Select a flavor</option>
                  <option
                    v-for="flavor in Flavors"
                    :key="flavor.flavor_id"
                    :value="flavor.flavor_id"
                  >
                    {{ flavor.description }}
                  </option>
                </select>
              </div>
            </td>
          </tr>
          <tr>
            <td>Frosting</td>
            <td>
              <div class="dropdown-container">
                <select v-model="newStandardCake.frosting">
                  <option value="" disabled>Select a frosting</option>
                  <option
                    v-for="frosting in Frostings"
                    :key="frosting.frosting_id"
                    :value="frosting.frosting_id"
                  >
                    {{ frosting.description }}
                  </option>
                </select>
              </div>
            </td>
          </tr>
          <tr>
            <td>Filling</td>
            <td>
              <div class="dropdown-container">
                <select v-model="newStandardCake.filling">
                  <option value="" disabled>Select a filling</option>
                  <option
                    v-for="filling in Fillings"
                    :key="filling.filling_id"
                    :value="filling.filling_id"
                  >
                    {{ filling.description }}
                  </option>
                </select>
              </div>
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
              <input
                id="cakeImage"
                type="text"
                v-model="newStandardCake.image"
              />
            </td>
          </tr>
          <tr>
            <td>
              <button class="button" @click="addStandardCake(newStandardCake)">
                Add New Cake to Standard Offerings
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
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
        const cakeToUpdate = this.listOfCakes.find(
          (cake) => cake.cake_id === id
        );

        // Toggle the availability status
        cakeToUpdate.availability = !cakeToUpdate.availability;
      });
    },
    deleteCake(id) {
      CakeService.deleteCake(id);
    },
    getAvailabilityText(Availability) {
      return Availability ? "Available" : "Not Available";
    },
    addStandardCake(newStandardCake) {
      CakeService.addStandardCake(newStandardCake).then(() => {
        window.location.reload();
      });
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
.table-container {
  display: flex;
  text-align: center;
  margin: 0 auto 0 auto;
  justify-content: center;
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
</style>