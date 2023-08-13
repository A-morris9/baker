<template>
  <div>
      <order-status-baker/>
      <standard-cakes-baker/>
  </div>   
</template>

<script>
import OrderStatusBaker from "@/components/OrderStatusBaker.vue";
import StandardCakesBaker from '../components/StandardCakesBaker.vue';

export default {
    name: "BakerView",
    components: {
        OrderStatusBaker,
        StandardCakesBaker
    }
}
</script>

<style>

</style>