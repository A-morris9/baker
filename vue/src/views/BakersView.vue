<template>
  <div>
      <bare-bones-header/>
      <order-status-baker/>
      <div class="divider"></div>
      <standard-cakes-baker/>
  </div>   
</template>

<script>
import OrderStatusBaker from "@/components/OrderStatusBaker.vue";
import StandardCakesBaker from '../components/StandardCakesBaker.vue';
import BareBonesHeader from '../components/BareBonesHeader.vue';

export default {
    name: "BakerView",
    components: {
        OrderStatusBaker,
        StandardCakesBaker,
        BareBonesHeader
    }
}
</script>

<style scoped>
.divider{
    width: 100%;
    height: 1px;
    background-color: rgb(	80, 71, 66);
}
</style>>

