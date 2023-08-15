<template>
  <div class="home">
    <bare-bones-header class="header" style="grid-area: header" />
    <bare-bones-footer class="footer" style="grid-area: footer" />
    <cake-list style="grid-area: list" />
  </div>
</template>

<script>
import BareBonesFooter from "../components/BareBonesFooter.vue";
import CakeList from "../components/CakeList.vue";
import BareBonesHeader from "../components/BareBonesHeader.vue";

export default {
  name: "home",
  components: {
    BareBonesFooter,
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
  display: grid;
  grid-template-columns: 150px 1fr 100px;
  grid-template-rows: 220px 1fr 50px;
  grid-template-areas:
    "header header header"
    "list list list"
    "footer footer footer";
  height: 100vh;
  margin: 0;
  padding: 0;
  border: none;
  gap: 0;
}
.header {
  position: sticky;
}
.footer {
  position: sticky;
}
</style>
