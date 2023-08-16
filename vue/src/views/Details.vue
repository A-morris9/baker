<template>
  <div>
    <bare-bones-header />
    <cake-detail />
  </div>
</template>

<script>
import BareBonesHeader from "../components/BareBonesHeader.vue";
import CakeDetail from "../components/CakeDetail.vue";

export default {
  components: { BareBonesHeader, CakeDetail },
  setup() {},
};
</script>

<style scoped>
</style>
