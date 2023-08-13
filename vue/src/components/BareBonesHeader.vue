<template>
  <div class="template-container">
    <div class="me">
      <img class="logo" v-bind:src="require('../assets/logo.png')" />
    </div>
    <router-link class="custom-style" :to="{ name: 'login' }" id="left-aligned"
      >Staff Login</router-link
    >
    |
    <router-link class="custom-style" v-bind:to="{ name: 'CustomCakeOrder' }">
      Order A Custom Cake</router-link
    >
    |
    <router-link
      class="custom-style"
      v-bind:to="{ name: 'OrderStatusCustomer' }"
    >
      View Order Status
    </router-link>
    |
    <router-link class="custom-style" v-bind:to="{ name: 'BakersView' }">
      View All Orders
    </router-link>
  </div>
</template>



<style scoped>
.template-container {
  font-family: "Big Shoulders Display", cursive;
  color: #444;
  background-color: rgb(210, 80, 128);
}
.me {
  text-align: center; /* Center the content horizontally */
  background-color: rgb(210, 80, 128);
}

#left-aligned {
  text-align: left;
}
.logo {
  width: 180px;
}
.custom-style {
  font-family: "Big Shoulders Display", cursive;
  font-size: 20px;
  text-decoration: none;
  color: rgb(	80, 71, 66);
}
</style>