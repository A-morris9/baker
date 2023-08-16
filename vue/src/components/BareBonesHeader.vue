<template>
  <div class="template-container">
    
      <img class="logo" v-bind:src="require('../assets/logo.png')" />
    
    <router-link class="custom-style" v-bind:to="{ name: 'home' }"
      >Home</router-link
    >&nbsp;&nbsp;

    <router-link class="custom-style" :to="{ name: 'login' }" id="left-aligned"
      >| Staff Login</router-link
    >

    <router-link class="custom-style" v-bind:to="{ name: 'CustomCakeView' }">
      | Order A Custom Cake</router-link
    >

    <router-link
      class="custom-style"
      v-bind:to="{ name: 'CustomerOrderStatus' }"
    >
      | View Order Status
    </router-link>

    <router-link class="custom-style" v-bind:to="{ name: 'BakersView' }">
      | Bakers Home Page
    </router-link>
    <router-link
      class="custom-style"
      v-bind:to="{ name: 'logout' }"
      v-if="$store.state.token != ''"
      >| Logout
    </router-link>
  </div>
</template>



<style scoped>
.template-container {
  font-family: "Big Shoulders Display", cursive;
  color: #444;
  background-color: rgb(210, 80, 128);
  margin: none;
  padding: none;
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
  font-size: 40px;
  text-decoration: none;
  color: rgb(80, 71, 66);
}
</style>