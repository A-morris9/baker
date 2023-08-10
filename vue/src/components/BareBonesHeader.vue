<template>
  <div class="template-container">
   <div class = "me">
     <h1>THE VERY BEST CAKE SHOP</h1>
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
</style>