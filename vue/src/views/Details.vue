<template>
    <div>
        <bare-bones-header/>
        <cake-detail/>
        <bare-bones-footer/>
    </div>
</template>

<script>
import BareBonesFooter from '../components/BareBonesFooter.vue';
import BareBonesHeader from "../components/BareBonesHeader.vue";
import CakeDetail from '../components/CakeDetail.vue';



export default {
  components: { BareBonesHeader, BareBonesFooter, CakeDetail },
    setup() {
        
    },
}
</script>

<style scoped>

</style>
