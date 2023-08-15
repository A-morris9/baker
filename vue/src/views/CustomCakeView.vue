<template>
    <div>
        <bare-bones-header/>
        <custom-cake-order/>
        <bare-bones-footer/>
    </div>
</template>

<script>
import BareBonesFooter from '../components/BareBonesFooter.vue';
import BareBonesHeader from "../components/BareBonesHeader.vue";
import CustomCakeOrder from '../components/CustomCakeOrder.vue';



export default {
  components: { BareBonesHeader, BareBonesFooter, CustomCakeOrder },
    setup() {
        
    },
}
</script>

<style scoped>

</style>
