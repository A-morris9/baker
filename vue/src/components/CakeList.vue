<template>
  <div class="cakes">
    Filter cake name by: <input type="text" v-model="filter" class="fancy" />
    <cake-card v-for="cake in filteredCakes" v-bind:key="cake.name" :cake="cake"></cake-card>
  </div>
</template>

<script>
import CakeCard from "./CakeCard.vue"
export default {
    data() 
  {
    return {
      filter: "",
    };
  },
    components: {
        CakeCard
    },
    computed: {
      filteredCakes() {
      if (this.filter) {
        return this.$store.state.cakes.filter((cake) => cake.name.toLowerCase().includes(this.filter.toLowerCase()));
      } else return this.$store.state.cakes;
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