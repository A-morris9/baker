<template>
  <div class="cake-box">
    <h2 class="title">{{ cake.title }}</h2>
    <img class="cake-image" :src="cake.image" />
    <h3>{{ cake.description }}</h3>
    <h3>Cake Type: {{ cake.style }}</h3>
    <h3>Flavor: {{ cake.flavor }}</h3>
    <h3>Frosting: {{ cake.frosting }}</h3>
    <h3>Filling: {{ cake.filling }}</h3>
    <h3>Price: ${{ cake.price }}</h3>
    <a
      id="show-form-button"
      href="#"
      v-on:click.prevent="showForm = true"
      v-if="showForm === false"
      >Place An Order (All fields are required)</a
    >
    <div class="form-box">
      <form
        class="form-style"
        v-on:submit.prevent="submitOrder"
        v-if="showForm === true"
      >
        <div class="form-element">
          <label for="firstName"></label>
          <input
            placeholder="First Name"
            id="firstName"
            type="text"
            v-model="newOrder.firstName"
          />
          <span class="error" v-if="!newOrder.firstName"></span>
        </div>
        <div class="form-element">
          <label for="lastName"></label>
          <input
            placeholder="Last Name"
            id="LastName"
            type="text"
            v-model="newOrder.lastName"
          />
          <span class="error" v-if="!newOrder.lastName"></span>
        </div>
        <div class="form-element">
          <label for="phoneNumber"></label>
          <input
            placeholder="Phone Number"
            id="phoneNumber"
            type="text"
            v-model="newOrder.phoneNumber"
          />
          <span class="error" v-if="!newOrder.phoneNumber"></span>
        </div>
        <div class="form-element">
          <label for="streetNumber"></label>
          <input
            placeholder="Street Number"
            id="streetNumber"
            type="text"
            v-model="newOrder.streetNumber"
          />
          <span class="error" v-if="!newOrder.streetNumber"></span>
        </div>
        <div class="form-element">
          <label for="streetName"></label>
          <input
            placeholder="Street Name"
            id="streetName"
            type="text"
            v-model="newOrder.streetName"
          />
          <span class="error" v-if="!newOrder.streetName"></span>
        </div>
        <div class="form-element">
          <label for="city"></label>
          <input
            placeholder="City"
            id="city"
            type="text"
            v-model="newOrder.city"
          />
          <span class="error" v-if="!newOrder.city"></span>
        </div>
        <div class="form-element">
          <label for="state"></label>
          <input
            placeholder="State"
            id="state"
            type="text"
            v-model="newOrder.state"
          />
          <span class="error" v-if="!newOrder.state"></span>
        </div>
        <div class="form-element">
          <label for="zipCode"></label>
          <input
            placeholder="Zip Code"
            id="zipCode"
            type="text"
            v-model="newOrder.zip"
          />
          <span class="error" v-if="!newOrder.zip"></span>
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
            v-model="newOrder.writing"
          />
        </div>
        <div class="actions" v-if="showForm === true">
          <button type="submit" :disabled="!isFormValid">Submit</button>
          <button v-on:click="resetForm" type="button">Cancel</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import CakeService from "../services/CakeService";

export default {
  data() {
    return {
      showForm: false,
      showTextArea: false,
      cake: {
        cake_id: "",
        title: "",
        description: "",
        price: "",
        style: "",
        size: "",
        flavor: "",
        frosting: "",
        filling: "",
        availability: "",
        image: "",
      },
      newOrder: {},
    };
  },

  created() {
    //$route.params.cake_id
    //this.cake= this.$store.state.cake
    CakeService.getCake(this.$route.params.id)
      .then((response) => {
        this.cake = response.data;
      })
      .catch((error) => alert(error));
  },
  methods: {
    submitOrder() {
      this.newOrder.price = this.cake.price;
      this.newOrder.cake_id = this.cake.cake_id;
      CakeService.placeOrder(this.newOrder).then((response) => {
        this.$router.push({
          name: "OrderConfirmation",
          params: { orderid: response.data.order_id },
        });
      });
    },
    displayTextArea() {
      this.showTextArea = !this.showTextArea;
    },
    resetForm() {
      this.showForm = false;
      this.showTextArea = false;
      this.newOrder = {};
    },
  },
  computed: {
    isFormValid() {
      return (
        this.newOrder.firstName &&
        this.newOrder.lastName &&
        this.newOrder.phoneNumber &&
        this.newOrder.streetNumber &&
        this.newOrder.streetName &&
        this.newOrder.city &&
        this.newOrder.state &&
        this.newOrder.zip
      );
    },
  },
};
</script>

<style scoped>
.cake-image {
  width: 20%;
}

.cake-box {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 20px 10px;
  background-image: url("../assets/Background.png");
  font-family: "poppins", cursive;
  color: rgba(80, 71, 66);
  min-height: 100vh;
}
.title {
  font-family: "Big Shoulders Display", cursive;
  color: rgba(80, 71, 66);
}
div.form-element {
  margin-top: 10px;
}
#show-form-button {
  font-weight: bold;
}
.form-style {
  font-family: poppins, cursive;
  font-weight: bold;
  color: rgba(80, 71, 66);
  display: flex;
  flex-direction: column;
  align-items: center;
}
.cake-image {
  border-radius: 12px;
}
</style>