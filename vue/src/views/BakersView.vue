<template>
  <div class="container">
      <bare-bones-header style="grid-area: header"/>
      <order-status-baker style="grid-area: order-status"/>
      <div class="divider"></div>
      <standard-cakes-baker style="grid-area: standard-cakes"/>
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
.container{

 display: grid;
  grid-template-columns: 150px 1fr 100px;
  grid-template-rows: 220px 1fr 50px;
  grid-template-areas:
    "header header header"
    "order-status order-status order-status"
    "standard-cakes standard-cakes standard-cakes";
  height: 100vh;
  margin: 0;
  padding: 0;
  border: none;
  gap:0;

  justify-content: center;
  align-content: center;
}
</style>>

