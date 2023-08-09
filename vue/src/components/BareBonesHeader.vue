<template>
  <div class="template-container">
   <div class = "me">
     <h1>The Very Best Cake Shop.</h1>
   </div>
   <router-link :to="{name : 'login'}" id = "left-aligned">Staff Login</router-link>
  </div>
</template>



<style scoped>
.template-container {
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