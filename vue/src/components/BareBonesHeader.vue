<template>
  <div class="template-container">
   <div class = "me">
     <img class="logo" v-bind:src="require('../assets/logo.png')" />
   </div>
   <router-link class="login-style" :to="{name : 'login'}" id = "left-aligned">Staff Login</router-link>
  </div>
</template>



<style scoped>
.template-container {
  font-family:'Big Shoulders Display', cursive;
  color:#444;
  background-color: rgb(	210, 80, 128);
}
.me {
  text-align: center; /* Center the content horizontally */
  background-color: rgb(	210, 80, 128);
}

#left-aligned {
  text-align: left;
}
.logo{
  width: 180px;
}
.login-style {
  font-family: 'Big Shoulders Display', cursive;
  font-size: 25px;
  text-decoration: none;
}
</style>