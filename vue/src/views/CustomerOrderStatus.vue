<template>
    <div>
        <bare-bones-header/>
        <order-status-customer/>
        <bare-bones-footer/>
    </div>
</template>

<script>
import BareBonesFooter from '../components/BareBonesFooter.vue';
import BareBonesHeader from "../components/BareBonesHeader.vue";
import OrderStatusCustomer from '../components/OrderStatusCustomer.vue';



export default {
  components: { BareBonesHeader, BareBonesFooter, OrderStatusCustomer },
    setup() {
        
    },
}
</script>

<style scoped>

</style>
