<template>
  <div class="container">
    <h1>Please select your custom cake options:</h1>
    <table class="form-style">
      <tbody>
        <tr>
          <td>Cake Style:</td>
          <td>
            <select v-model="newCustomCake.style">
              <option value="" disabled>------ Select a style ------</option>
              <option
                v-for="style in Styles"
                :key="style.id"
                :value="style.name"
              >
                {{ style.name }}
              </option>
            </select>
            <span class="error" v-if="!newCustomCake.style"></span>
          </td>
        </tr>
        <tr>
          <td>Flavor:</td>
          <td>
            <select v-model="newCustomCake.flavor">
              <option value="" disabled>------ Select a flavor -----</option>
              <option
                v-for="flavor in Flavors"
                :key="flavor.flavor_id"
                :value="flavor.flavor_id"
              >
                {{ flavor.description }}
              </option>
            </select>
            <span class="error" v-if="!newCustomCake.flavor"></span>
          </td>
        </tr>
        <tr>
          <td>Frosting:</td>
          <td>
            <select v-model="newCustomCake.frosting">
              <option value="" disabled>--- Select a frosting ---</option>
              <option
                v-for="frosting in Frostings"
                :key="frosting.frosting_id"
                :value="frosting.frosting_id"
              >
                {{ frosting.description }}
              </option>
            </select>
            <span class="error" v-if="!newCustomCake.frosting"></span>
          </td>
        </tr>
        <tr>
          <td>Filling:</td>
          <td>
            <select v-model="newCustomCake.filling">
              <option value="" disabled>----- Select a filling ------</option>
              <option
                v-for="filling in Fillings"
                :key="filling.filling_id"
                :value="filling.filling_id"
              >
                {{ filling.description }}
              </option>
            </select>
            <span class="error" v-if="!newCustomCake.filling"></span>
          </td>
        </tr>
        <!-- Add more parameter rows as needed -->
      </tbody>
    </table>
    <form class="form-style" v-on:submit.prevent="submitCustomOrder">
      <div class="form-element">
        <label for="firstName"></label>
        <input
          placeholder="First Name"
          id="firstName"
          type="text"
          v-model="newCustomOrder.firstName"
        />
        <span class="error" v-if="!newCustomOrder.firstName"></span>
      </div>
      <div class="form-element">
        <label for="lastName"></label>
        <input
          placeholder="Last Name"
          id="LastName"
          type="text"
          v-model="newCustomOrder.lastName"
        />
        <span class="error" v-if="!newCustomOrder.lastName"></span>
      </div>
      <div class="form-element">
        <label for="phoneNumber"></label>
        <input
          placeholder="Phone Number"
          id="phoneNumber"
          type="text"
          v-model="newCustomOrder.phoneNumber"
        />
        <span class="error" v-if="!newCustomOrder.phoneNumber"></span>
      </div>
      <div class="form-element">
        <label for="streetNumber"></label>
        <input
          placeholder="Street Number"
          id="streetNumber"
          type="text"
          v-model="newCustomOrder.streetNumber"
        />
        <span class="error" v-if="!newCustomOrder.streetNumber"></span>
      </div>
      <div class="form-element">
        <label for="streetName"></label>
        <input
          placeholder="Street Name"
          id="streetName"
          type="text"
          v-model="newCustomOrder.streetName"
        />
        <span class="error" v-if="!newCustomOrder.streetName"></span>
      </div>
      <div class="form-element">
        <label for="city"></label>
        <input
          placeholder="City"
          id="city"
          type="text"
          v-model="newCustomOrder.city"
        />
        <span class="error" v-if="!newCustomOrder.city"></span>
      </div>
      <div class="form-element">
        <label for="state"></label>
        <input
          placeholder="State"
          id="state"
          type="text"
          v-model="newCustomOrder.state"
        />
        <span class="error" v-if="!newCustomOrder.state"></span>
      </div>
      <div class="form-element">
        <label for="zipCode"></label>
        <input
          placeholder="Zip Code"
          id="zipCode"
          type="text"
          v-model="newCustomOrder.zip"
        />
        <span class="error" v-if="!newCustomOrder.zip"></span>
      </div>
      <p>
        Would you like to add writing to your cake? (+5$)
        <input type="checkbox" v-on:change="displayTextArea()" />
      </p>
      <div class="form-element" v-if="showTextArea === true">
        <label for="cakeWriting"></label>
        <textarea
          placeholder="Writing to Appear on cake"
          id="cakeWriting"
          rows="8"
          cols="60"
          v-model="newCustomOrder.writing"
        />
      </div>
      <div>
        <button class="button" type="submit" :disabled="!isFormValid">
          Submit Order
        </button>
        <button class="button" v-on:click="resetForm" type="button">
          Cancel
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import CakeService from "../services/CakeService";

export default {
  data() {
    return {
      showTextArea: false,
      Styles: [
        { id: 1, name: "Layer" },
        { id: 2, name: "Sheet" },
        { id: 3, name: "Cupcakes" },
      ],
      Flavors: [],
      Frostings: [],
      Fillings: [],
      newCustomCake: {
        price: 27,
      },
      newCustomOrder: {
        price: 27,
        cake_id: 0,
      },
    };
  },
  created() {
    //$route.params.cake_id
    //this.cake= this.$store.state.cake
    CakeService.getFlavors().then((response) => {
      this.Flavors = response.data;
    });
    CakeService.getFillings().then((response) => {
      this.Fillings = response.data;
    });
    CakeService.getFrostings().then((response) => {
      this.Frostings = response.data;
    });
  },
  methods: {
    displayTextArea() {
      this.showTextArea = !this.showTextArea;
    },
    resetForm() {
      this.showTextArea = false;
      this.newCustomCake = {};
    },
    submitCustomOrder() {
      CakeService.addCustomCake(this.newCustomCake).then((response) => {
        this.newCustomOrder.cake_id = response.data.cake_id;
        this.submitNewOrder(this.newCustomOrder);
      });
    },
    submitNewOrder(newCustomOrder) {
      CakeService.placeCustomOrder(newCustomOrder).then((response) => {
        this.$router.push({
          name: "OrderConfirmation",
          params: { orderid: response.data.order_id },
        });
      });
    },
  },
  computed: {
    isFormValid() {
      return (
        this.newCustomCake.style &&
        this.newCustomCake.flavor &&
        this.newCustomCake.frosting &&
        this.newCustomCake.filling &&
        this.newCustomOrder.firstName &&
        this.newCustomOrder.lastName &&
        this.newCustomOrder.phoneNumber &&
        this.newCustomOrder.streetNumber &&
        this.newCustomOrder.streetName &&
        this.newCustomOrder.city &&
        this.newCustomOrder.state &&
        this.newCustomOrder.zip
      );
    },
  },
};
</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 1fr;
  font-family: "poppins", cursive;
  font-weight: bold;
  color: rgba(80, 71, 66);
  width: fit-content;
  margin: auto;
}
div.form-element {
  margin-top: 10px;
}

th,
td {
  text-align: left;
  color: rgba(80, 71, 66);
  font-family: "Poppins", cursive;
}

td {
  font-weight: bold;
}

body {
  background-image: none;
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
h1 {
  font-family: "Big Shoulders Display", cursive;
}
</style>