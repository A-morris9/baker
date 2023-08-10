<template>
  <div class = "fancy-background">
  
    <hr class = "divider"/> 
    <hr class = "divider" />
    Filter cake name by: <input type="text" v-model="filter" class="fancy" />
   <div class="cakes">
    <cake-card v-for="cake in filteredCakes" v-bind:key="cake.cake_id" :cake="cake" class="cake-card"></cake-card>
   </div>
  </div> 
</template>

<script>
import cakeService from "../services/CakeService.js"
import CakeCard from "./CakeCard.vue"

export default {
    data() {
    return {
      filter: "",
      standardCakes: {
        standardList: [],
       }
    };
  },
  created(){
    cakeService.getCakes().then((Response)=> {
      this.standardCakes.standardList = Response.data;
    })
  },
    components: {
        CakeCard
    },
    computed: {
      filteredCakes() {
      if (this.filter) {
        return this.standardCakes.standardList.filter((cake) => cake.title.toLowerCase().includes(this.filter.toLowerCase()));
      } else return this.standardCakes.standardList;
    },
    }

}
</script>

<style>
 .cakes {  
  display: flex; 
  flex-wrap : wrap;
  justify-content: space-around;
  align-items: center;
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  padding: 20px;
  gap:100px
}
.cake-card {
  width: calc(250px - 20px); /* 20% width with 20px spacing */
  height: 300px;
  margin-bottom: 20px; /* Add some bottom margin for spacing */
  justify-content: center;
}
.fancy-background {
  background-image: url('https://img.freepik.com/free-vector/blank-leafy-frame-social-ads_53876-100923.jpg?w=2000');
}
.fancy {
  background-color: bisque;
  margin-top: 10px;
}
.divider {
  border: none; /* Remove the border */
  
}
</style>