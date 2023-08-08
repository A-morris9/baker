<template>
  <div class = "cake-box">  
    <h2>{{cake.title}}</h2>
    <img class="cake-image" :src="cake.image" />
    <h3>{{cake.description}} </h3>
    <h3>{{cake.style}} </h3>
    <h3>$ {{cake.price}} </h3>
    <button class="order-button">Order Now</button>
  </div>
</template>

<script>
import CakeService from '../services/CakeService';

export default {
 data() {
       return {cake : {
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
                 }       
    }
    },

    created() { //$route.params.cake_id
        //this.cake= this.$store.state.cake
        CakeService.getCake(this.$route.params.id)
        .then((response) => 
        {this.cake = response.data}).catch((error) => alert(error))
    }
}
</script>

<style>
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
}

</style>