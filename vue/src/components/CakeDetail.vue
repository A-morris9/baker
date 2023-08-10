<template>
  <div class = "cake-box">  
    <h2>{{cake.title}}</h2>
    <img class="cake-image" :src="cake.image" />
    <h3>{{cake.description}} </h3>
    <h3>{{cake.style}} </h3>
    <h3>$ {{cake.price}}</h3>
    <a
      id="show-form-button"
      href="#"
      v-on:click.prevent="showForm = true"
      v-if="showForm === false"
      >Place An Order</a
    >
    <form v-on:submit.prevent="sumbitOrder" v-if="showForm === true">
      <div class="form-element">
        <label for="firstName">First Name: </label>
        <input id="firstName" type="text" v-model="newOrder.firstName" />
      </div>
      <div class="form-element">
        <label for="lastName">Last Name: </label>
        <input id="LastName" type="text" v-model="newOrder.lastName" />
      </div>
      <div class="form-element">
        <label for="phoneNumber">Phone Number: </label>
        <input id="phoneNumber" type="text" v-model="newOrder.phoneNumber" />
      </div>
      <div class="form-element">
        <label for="streetNumber">Street Number: </label>
        <input id="streetNumber" type="text" v-model="newOrder.streetNumber" />
      </div>
      <div class="form-element">
        <label for="streetName">Street Name: </label>
        <input id="streetName" placeholder="Street Name" type="text" v-model="newOrder.streetName" />
      </div>
      <div class="form-element">
        <label for="city">City: </label>
        <input id="city" type="text" v-model="newOrder.city" />
      </div>
      <div class="form-element">
        <label for="state">State: </label>
        <input id="state" type="text" v-model="newOrder.state" />
      </div>
      <div class="form-element">
        <label for="zipCode">Zip Code: </label>
        <input id="zipCode" type="text" v-model="newOrder.zip" />
      </div>
      <p>Would you like to add writing to your cake? (+5$) <input type="checkbox" v-on:change="displayTextArea()"/>
      </p>
      <div class="form-element" v-if="showTextArea === true">
        <label for="cakeWriting">Writing to Appear on cake: </label>
        <textarea id="cakeWriting" rows="8" cols="60" v-model="newOrder.writing" />
      </div>
      <div class="actions" v-if="showForm === true">
        <button v-on:click="resetForm" type="button">Cancel</button>
        <button>Submit</button>
      </div>
    </form>
  </div>
</template>

<script>
import CakeService from '../services/CakeService';


export default {
 data() {
       return {
         showForm: false,
         showTextArea: false,
         cake : {
         cake_id: "",
         title: "",
         description: "",
         price: "",
         style: "",
         size: "",
         flavor: "",
         frosting: "",
         filling:"",
         availability: "",
         image: ""
                 },
        newOrder:{
           

         }               
    }
    },

    created() { //$route.params.cake_id
        //this.cake= this.$store.state.cake
        CakeService.getCake(this.$route.params.id)
        .then((response) => 
        {this.cake = response.data
        this.newOrder.price = this.cake.price
        this.newOrder.cake_id = this.cake.cake_id}).catch((error) => alert(error))

    },
    methods: {
      submitOrder() {
        const Order = this.newOrder
        CakeService.placeOrder(Order).then(response => {
          if (response.status === 201) {
            this.$router.push({name: 'OrderConfirmation', params: {orderid:response.data.order_id}})
          }

        })
      },
      displayTextArea() {
        this.showTextArea =! this.showTextArea
      },
      resetForm() {
        this.showForm = false;
        this.showTextArea = false;
        this.newOrder = {}
      }
    }
}
</script>

<style scoped>
.cake-image {
  width: 20%;
}

.cake-box {
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 1px solid #ccc; /* Add a border around the box */
  border-radius: 10px;    /* Rounded edges */
  padding: 20px 10px;     /* Vertical padding: 20px, Horizontal padding: 10px */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Add a subtle box shadow */
  background-color: #fff; /* Background color for the box */
  overflow: hidden;       /* Hide any content that overflows */
  background-image: url('https://img.freepik.com/free-vector/blank-leafy-frame-social-ads_53876-100923.jpg?w=2000');
}
div.form-element {
  margin-top: 10px;
}

</style>