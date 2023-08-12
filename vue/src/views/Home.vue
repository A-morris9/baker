<template>
  <div class="home">
    <bare-bones-header style="grid-area: header" />
    <bare-bones-footer style="grid-area: footer" />
    <cake-list style="grid-area: list" />
  </div>
</template>

<script>
import BareBonesFooter from '../components/BareBonesFooter.vue';
import CakeList from '../components/CakeList.vue';
import BareBonesHeader from '../components/BareBonesHeader.vue';

export default {
  name: "home",
  components: {
    BareBonesFooter,
    CakeList,
    BareBonesHeader
  }
};
</script>

<style scoped>
.home {
  display: grid;
  grid-template-columns: 150px 1fr 100px;
  grid-template-rows: 220px 1fr 50px;
  grid-template-areas:
    "header header header"
    "list list list"
    "footer footer footer";
  height: 100vh;
  gap: 5px;
  background: gray;
  
}

</style>
