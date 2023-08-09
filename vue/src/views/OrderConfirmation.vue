<template>
  <h1> This is an order confirmation page for order number: {{$route.order_id}}</h1>
</template>

<script>
import CakeService from '../services/CakeService'
export default {
  data() {
    // order = {},
    // cake = {}
  },
  created() {
    CakeService.getOrder(this.$route.order_id).then((response) => {
      this.order=response.data;
    CakeService.getCake(this.order.cake_id).then((response) => {
      this.cake=response.data;
    })  
    })
  }

}
</script>

<style>

</style>