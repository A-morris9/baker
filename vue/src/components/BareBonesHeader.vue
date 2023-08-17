<template>
  <div class="template-container">
    <div>
      <img class="logo" v-bind:src="require('../assets/logo.png')" />
    </div>
    <div class="links">
      <router-link
        class="custom-style"
        v-bind:to="{ name: 'home' }"
        v-bind:class="{ active: isRouteActive('home') }"
        >Home</router-link
      >&nbsp;&nbsp;

      <router-link
        class="custom-style"
        v-bind:to="{ name: 'CustomCakeView' }"
        v-bind:class="{ active: isRouteActive('CustomCakeView') }"
      >
        | Order A Custom Cake</router-link
      >

      <router-link
        class="custom-style"
        v-bind:to="{ name: 'CustomerOrderStatus' }"
        v-bind:class="{ active: isRouteActive('CustomerOrderStatus') }"
      >
        | View Order Status
      </router-link>
      <router-link
        class="custom-style"
        :to="{ name: 'login' }"
        id="left-aligned"
        v-bind:class="{ active: isRouteActive('login') }"
      >
        | Staff Login
      </router-link>
      <router-link
        class="custom-style"
        v-bind:to="{ name: 'BakersView' }"
        v-if="$store.state.token != ''"
        v-bind:class="{ active: isRouteActive('BakersView') }"
      >
        | Bakers Home Page
      </router-link>

      <router-link
        class="custom-style"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        v-bind:class="{ active: isRouteActive('logout') }"
        >| Logout
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    isRouteActive(routeName) {
      return this.$route.name === routeName;
    },
  },
};
</script>




<style scoped>
.active {
  font-weight: bold;
}
.template-container {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
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
  font-size: 40px;
  text-decoration: none;
  color: rgb(238, 229, 220);
}
</style>