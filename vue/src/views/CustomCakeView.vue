<template>
  <div class="style">
    <bare-bones-header class="header" style="grid-area: header" />
    <custom-cake-order class="custom" style="grid-area: custom" />
    
  </div>
</template>

<script>

import BareBonesHeader from "../components/BareBonesHeader.vue";
import CustomCakeOrder from "../components/CustomCakeOrder.vue";

export default {
  components: { BareBonesHeader, CustomCakeOrder },
  setup() {},
};
</script>

<style scoped>
.style {
  display: grid;
  grid-template-columns: 150px 1fr 100px; /* Single column for the entire row */
  grid-template-rows: 220px 1fr 50px;
  grid-gap: 20px; /* Adjust the gap between components */
  grid-template-areas:
    "header header header"
    "custom custom custom"
    ;
  height: 95vh;
}
</style>
