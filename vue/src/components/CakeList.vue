<template>
  <div class="cakes">
    <cake-card v-for="cake in $store.state.cakes" v-bind:key="cake.name" :cake="cake"></cake-card>
  </div>
</template>

<script>
import CakeCard from "./CakeCard.vue"
export default {
    components: {
        CakeCard
    },

}
</script>

<style>
 .cakes {
  background-color: rgb(255, 0, 200);
}
</style>