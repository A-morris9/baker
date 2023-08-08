<template>
  <div class="cakes">
    <div class="scrolling-h1">
      <h1>Feast Your Eyes On Our Delectable Confections</h1>
    </div>
    <hr /> 
    <hr />
    <div> 
     Filter cake name by: <input type="text" v-model="filter" class="fancy" />
    </div>
    <cake-card v-for="cake in filteredCakes" v-bind:key="cake.cake_id" :cake="cake"></cake-card>
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
  
  @keyframes scroll {
    0% {
        transform: translateX(100%);
    }
    100% {
        transform: translateX(-100%);
    }
  }
  .scrolling-h1 {
    position: absolute;
    top: 11%;
    right: 0;
    left: 0;
    transform: translateX(-100%);
    white-space: nowrap; 
    animation: scroll 10s linear infinite; 
  }
 .cakes {
  display: flex; 
  flex-wrap : wrap;
  justify-content: space-between;
  align-items: center;
  background-image: url(https://c4.wallpaperflare.com/wallpaper/958/739/664/birthday-party-wallpaper-preview.jpg) ;
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
}
.fancy {
  background-color: rgb(0, 68, 100);
  margin-top: 10px;
}
</style>