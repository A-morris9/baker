<template>
  <div>
    <bare-bones-header />
    <div class="grid-container">
      <button @click="showOrderStatus = true">Show Order Status</button>
      <button @click="showOrderStatus = false">Show Standard Cakes</button>

      <div class="side-by-side">
        <order-status-baker v-if="showOrderStatus" />
        <standard-cakes-baker v-else />
      </div>
    </div>
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
    },
    data(){
        return{
            showOrderStatus: true,
        }
    }
}
</script>

<style scoped>
.divider{
    width: 100%;
    height: 1px;
    background-color: rgb(	80, 71, 66);
}
.grid-container {
  display: grid;
  grid-template-columns: 1fr; /* Single column for the entire row */
  grid-gap: 20px; /* Adjust the gap between components */
}

.side-by-side {
  display: flex;
  justify-content: space-between; /* Space between the components */
  align-items: top; /* Center vertically within the row */
}

</style>>

