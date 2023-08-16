<template>
  <div class="home">
    <bare-bones-header class="header" style="grid-area: header" />
    <cake-list style="grid-area: list" />
  </div>
</template>

<script>
import CakeList from "../components/CakeList.vue";
import BareBonesHeader from "../components/BareBonesHeader.vue";

export default {
  name: "home",
  components: {
    CakeList,
    BareBonesHeader,
  },
};
</script>

<style scoped>
body {
  overflow: hidden;
}
.home {
  overflow: hidden;
  display: grid;
  grid-template-columns: 150px 1fr;
  grid-template-rows: 200px 1fr;
  grid-template-areas:
    "header header header"
    "list list list";
  height: 95vh;
}
</style>
