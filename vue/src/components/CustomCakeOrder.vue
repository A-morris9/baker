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
                        <input type="radio" name="param1" value="option1" v-model="newCustomCake.style"> {{style.name}}
                    </label>
                </td>
            </tr>
            <tr>
                <td>Flavor</td>
                <td>
                    <label v-for="flavor in Flavors" v-bind:key="flavor.id">
                        <input type="radio" name="param2" value="option1" v-model="newCustomCake.flavor"> {{ flavor.description }}
                    </label>
                </td>
            </tr>
            <tr>
                <td>Frosting</td>
                <td>
                    <label v-for="frosting in Frostings" v-bind:key="frosting.id">
                        <input type="radio" name="param3" value="option1" v-model="newCustomCake.frosting"> {{ frosting.description }}
                    </label>
                </td>
            </tr>
            <!-- Add more parameter rows as needed -->
        </tbody>
    </table>
    <form class="form-style" v-on:submit.prevent="submitOrder">
      <div class="form-element">
        <label for="firstName">First Name: </label>
        <input id="firstName" type="text" v-model="newCustomOrder.firstName" />
      </div>
      <div class="form-element">
        <label for="lastName">Last Name: </label>
        <input id="LastName" type="text" v-model="newCustomOrder.lastName" />
      </div>
      <div class="form-element">
        <label for="phoneNumber">Phone Number: </label>
        <input id="phoneNumber" type="text" v-model="newCustomOrder.phoneNumber" />
      </div>
      <div class="form-element">
        <label for="streetNumber">Street Number: </label>
        <input id="streetNumber" type="text" v-model="newCustomOrder.streetNumber" />
      </div>
      <div class="form-element">
        <label for="streetName">Street Name: </label>
        <input id="streetName" type="text" v-model="newCustomOrder.streetName" />
      </div>
      <div class="form-element">
        <label for="city">City: </label>
        <input id="city" type="text" v-model="newCustomOrder.city" />
      </div>
      <div class="form-element">
        <label for="state">State: </label>
        <input id="state" type="text" v-model="newCustomOrder.state" />
      </div>
      <div class="form-element">
        <label for="zipCode">Zip Code: </label>
        <input id="zipCode" type="text" v-model="newCustomOrder.zip" />
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
        <button v-on:click="resetForm" type="button">Cancel</button>
        <button type="submit">Submit Order</button>
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
        { id: 3, name: 'Cupckaes' }   
        ],
        Flavors : [],
        Frostings : [],
        newCustomCake : {},
        newCustomOrder: {}
       }
    },
    created() {
    //$route.params.cake_id
    //this.cake= this.$store.state.cake
    CakeService.getFlavors()
      .then((response) => {
        this.Flavors = response.data;
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
          
      }
  };

</script>

<style>
.form-style{
  font-family: poppins,sans-serif;
  font-weight: bold;
}

div.form-element {
  margin-top: 10px;
}

</style>