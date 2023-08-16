<template>
  <div>
    <bare-bones-header />
    <div class="container">
      <button class="button" @click="showOrderStatus = !showOrderStatus">
        Show Cakes/Orders
      </button>

      <div>
        <order-status-baker v-if="showOrderStatus" />
        <standard-cakes-baker v-else />
      </div>
    </div>
  </div>
</template>

<script>
import OrderStatusBaker from "@/components/OrderStatusBaker.vue";
import StandardCakesBaker from "../components/StandardCakesBaker.vue";
import BareBonesHeader from "../components/BareBonesHeader.vue";

export default {
  name: "BakerView",
  components: {
    OrderStatusBaker,
    StandardCakesBaker,
    BareBonesHeader,
  },
  data() {
    return {
      showOrderStatus: true,
    };
  },
};
</script>

<style scoped>
.divider {
  width: 100%;
  height: 1px;
  background-color: rgb(80, 71, 66);
}

button {
  background-color: #4caf50; /* Green */
  border: none;
  color: white;
  padding: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 12px;
  width: 150px;
}
.container {
  text-align: center;
 
}
</style>>

