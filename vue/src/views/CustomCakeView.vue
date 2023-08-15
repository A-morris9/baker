<template>
    <div class = 'style'>
        <bare-bones-header class="header" style="grid-area: header"/>
        <custom-cake-order class="custom" style="grid-area: custom"/>
        <bare-bones-footer class = 'footer' style="grid-area: footer"/>
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
.style{
    display: grid;
    grid-template-columns: 150px 1fr 100px; /* Single column for the entire row */
    grid-template-rows: 220px 1fr 100px;
    grid-gap: 20px; /* Adjust the gap between components */
    grid-template-areas: 
     "header header header"
    "custom custom custom"
    "footer footer footer";
    height: 100vh;
}


</style>
