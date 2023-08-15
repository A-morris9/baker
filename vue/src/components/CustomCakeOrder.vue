<template>
<div>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parameter Options</title>
  </head>
  <body>
    <table>
        <thead>
            <tr>
                <th>Parameter</th>
                <th>Options</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Cake Style</td>
                <td>
                    <label v-for="style in Styles" v-bind:key="style.id">
                        <input type="radio" name="param1" :value="style.id" v-model="newCustomCake.style"> {{style.name}}
                        <span class="error" v-if="!newCustomCake.style"></span>
                    </label>
                </td>
            </tr>
            <tr>
                <td>Flavor</td>
                <td>
                    <label v-for="flavor in Flavors" v-bind:key="flavor.flavor_id">
                        <input type="radio" name="param2" v-bind:value="flavor.flavor_id" v-model="newCustomCake.flavor" /> {{ flavor.description }}
                        <span class="error" v-if="!newCustomCake.flavor"></span>
                    </label>
                </td>
            </tr>
            <tr>
                <td>Frosting</td>
                <td>
                    <label v-for="frosting in Frostings" v-bind:key="frosting.frosting_id">
                        <input type="radio" name="param3" v-bind:value="frosting.frosting_id" v-model="newCustomCake.frosting"> {{ frosting.description }}
                        <span class="error" v-if="!newCustomCake.frosting"></span>
                    </label>
                </td>
            </tr>
            <tr>
                <td>Filling</td>
                <td>
                    <label v-for="filling in Fillings" v-bind:key="filling.filling_id">
                        <input type="radio" name="param4" v-bind:value="filling.filling_id" v-model="newCustomCake.filling"> {{ filling.description }}
                        <span class="error" v-if="!newCustomCake.filling"></span>
                    </label>
                </td>
            </tr>
            <!-- Add more parameter rows as needed -->
        </tbody>
    </table>
    <form class="form-style" v-on:submit.prevent="submitCustomOrder">
      <div class="form-element">
        <label for="firstName">First Name: </label>
        <input id="firstName" type="text" v-model="newCustomOrder.firstName" />
        <span class="error" v-if="!newCustomOrder.firstName"></span>
      </div>
      <div class="form-element">
        <label for="lastName">Last Name: </label>
        <input id="LastName" type="text" v-model="newCustomOrder.lastName" />
        <span class="error" v-if="!newCustomOrder.lastName"></span>
      </div>
      <div class="form-element">
        <label for="phoneNumber">Phone Number: </label>
        <input id="phoneNumber" type="text" v-model="newCustomOrder.phoneNumber" />
        <span class="error" v-if="!newCustomOrder.phoneNumber"></span>
      </div>
      <div class="form-element">
        <label for="streetNumber">Street Number: </label>
        <input id="streetNumber" type="text" v-model="newCustomOrder.streetNumber" />
        <span class="error" v-if="!newCustomOrder.streetNumber"></span>
      </div>
      <div class="form-element">
        <label for="streetName">Street Name: </label>
        <input id="streetName" type="text" v-model="newCustomOrder.streetName" />
        <span class="error" v-if="!newCustomOrder.streetName"></span>
      </div>
      <div class="form-element">
        <label for="city">City: </label>
        <input id="city" type="text" v-model="newCustomOrder.city" />
        <span class="error" v-if="!newCustomOrder.city"></span>
      </div>
      <div class="form-element">
        <label for="state">State: </label>
        <input id="state" type="text" v-model="newCustomOrder.state" />
        <span class="error" v-if="!newCustomOrder.state"></span>
      </div>
      <div class="form-element">
        <label for="zipCode">Zip Code: </label>
        <input id="zipCode" type="text" v-model="newCustomOrder.zip" />
        <span class="error" v-if="!newCustomOrder.zip"></span>
      </div>
      <p>
        Would you like to add writing to your cake? (+5$)
        <input type="checkbox" v-on:change="displayTextArea()" />
      </p>
      <div class="form-element" v-if="showTextArea === true">
        <label for="cakeWriting">Writing to Appear on cake: </label>
        <textarea
          id="cakeWriting"
          rows="8"
          cols="60"
          v-model="newCustomOrder.writing"
        />
      </div>
      <div>
        <button type="submit" :disabled="!isFormValid">Submit Order</button>
        <button v-on:click="resetForm" type="button">Cancel</button>
      </div>
    </form>
  </body>
 </div> 
</template>

<script>
import CakeService from "../services/CakeService";

export default {
        data() {
    return {
        showTextArea : false,
        Styles: [
        { id: 1, name: 'Layer' },
        { id: 2, name: 'Sheet' },
        { id: 3, name: 'Cupcakes' }   
        ],
        Flavors : [],
        Frostings : [],
        Fillings : [],
        newCustomCake : {
          price : 27
        },
        newCustomOrder: {
          price: 27,
          cake_id: 0
        }
       }
    },
    created() {
    //$route.params.cake_id
    //this.cake= this.$store.state.cake
    CakeService.getFlavors()
      .then((response) => {
        this.Flavors = response.data;
      });
      CakeService.getFillings()
      .then((response) => {
        this.Fillings = response.data;
      });
    CakeService.getFrostings()
      .then((response) => {
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
            CakeService.addCustomCake(this.newCustomCake).then ((response) => {
              this.newCustomOrder.cake_id = response.data.cake_id;
              this.submitNewOrder(this.newCustomOrder)
            })},
           submitNewOrder(newCustomOrder) { 
            CakeService.placeCustomOrder(newCustomOrder).then((response) => {
              this.$router.push({
            name: "OrderConfirmation",
            params: { orderid: response.data.order_id },
          });
            })
           }
          
      },
      computed: {
        isFormValid(){
          return(
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
          )
        }

      }
  };

</script>

<style scoped>
.form-style{
  font-family: 'poppins', cursive;
  font-weight: bold;
  color: rgba(80,71,66);
}

div.form-element {
  margin-top: 10px;
}

th, td  {
  color: rgba(80,71,66);
  font-family: 'Poppins', cursive;
}

td {
  font-weight: bold;
}

</style>