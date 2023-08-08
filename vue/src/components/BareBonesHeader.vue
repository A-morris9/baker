<template>
  <div class="me">
    <h1>I'll take you to the cake shop.</h1>
    <router-link :to="{name : 'login'}">Staff Login</router-link>
  </div>
</template>



<style scoped>
.me {
  background-color: cyan;
  text-align: center;
}
</style>