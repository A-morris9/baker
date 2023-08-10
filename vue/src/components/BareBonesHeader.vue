<template>
  <div class="template-container">
   <div class = "me">
     <img class="logo" v-bind:src="require('../assets/logo.png')" />
   </div>
   <router-link :to="{name : 'login'}" id = "left-aligned">Staff Login</router-link>
  </div>
</template>



<style scoped>
.template-container {
  font-family:'Big Shoulders Display', cursive;
  color:#444;
  background-color: bisque;
}
.me {
  text-align: center; /* Center the content horizontally */
  background-color: bisque;
}

#left-aligned {
  text-align: left;
}
.logo{
  width: 180px;
}
</style>