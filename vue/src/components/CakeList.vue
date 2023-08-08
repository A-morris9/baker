<template>
  <div class="cakes">
    Filter cake name by: <input type="text" v-model="filter" class="fancy" />
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
 .cakes {
  background-color: rgb(255, 0, 200);
}
.fancy {
  background-color: darkgreen;
  margin-top: 10px;
}
</style>