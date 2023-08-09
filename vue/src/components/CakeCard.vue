<template>
  <div class="cake" v-on:click="viewCake(cake)">
      <h2 class="cake-name" style ="grid-area: name">{{ cake.title }}</h2>
       
      <img class="cake-image" style = "grid-area: image" :src="cake.image"/>
  </div>
</template>

<script>
export default {
    name: 'cake-card',
    props: {
    cake: {
        type: Object,
        required: true,
    }    
    },
    methods: {
        viewCake(cake) {
            this.$router.push({name:"CakeDetail",params:{id:cake.cake_id}})
        }
    },
 
   

}
</script>

<style>
.cake {
    display: grid;
    grid-template-rows: 1fr 1fr;
    grid-template-areas:
    "name" 
    "image";
    border: 2px solid black;
    border-radius: 10px;
    width: 20%;
    height: 180px;
    margin: 20px auto;
    justify-items: center;
    align-items: center;
    text-align: center;
    cursor: pointer;
    
}
.cake-image {
    width: 70%;
    height: 80%;
    margin-top: -10px
}

</style>