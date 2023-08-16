<template>
  <div class="fancy-background carousel">
    <div class="writing">
      <div class="filter">
        <label class="custom-style" for="filter"> Filter Cake Name By: </label>
        <input type="text" v-model="filter" class="fancy" />
      </div>
      <div>
        <h1>
          Choose one of our standard cakes or select Order A Custom Cake to make
          your own!
        </h1>
      </div>
    </div>
    <div class="carousel__container">
      <cake-card
        v-for="cake in filteredCakes"
        v-bind:key="cake.cake_id"
        :cake="cake"
        class="cake-card"
      ></cake-card>
    </div>
  </div>
</template>

<script>
import cakeService from "../services/CakeService.js";
import CakeCard from "./CakeCard.vue";

export default {
  data() {
    return {
      filter: "",
      standardCakes: {
        standardList: [],
      },
    };
  },
  created() {
    cakeService.getCakes().then((Response) => {
      this.standardCakes.standardList = Response.data;
    });
  },
  components: {
    CakeCard,
  },
  computed: {
    filteredCakes() {
      if (this.filter) {
        return this.standardCakes.standardList.filter((cake) =>
          cake.title.toLowerCase().includes(this.filter.toLowerCase())
        );
      } else return this.standardCakes.standardList;
    },
  },
};
</script>

<style scoped>
.carousel {
  width: 100%;
  overflow-x: auto;

  padding-top: 80px;
  position: relative;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

.carousel__container {
  padding-left: 100px;
  display: inline-block;
  overflow: hidden;
  justify-content: center;
}

.fancy {
  background-color: rgb(238, 229, 220e);
  margin-top: 10px;
}
.divider {
  border: none;
}
.custom-style {
  font-family: "Big Shoulders Display", cursive;
  font-size: 20px;
  text-decoration: none;
  color: rgb(80, 71, 66);
}
.filter {
  position: absolute;
}
.writing {
  display: flex;
  justify-content: center;
}
h1 {
  padding-top: 50px;
  font-family: "Big Shoulders Display", cursive;
  color: rgb(80, 71, 66);
}
</style>