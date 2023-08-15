<template>
        <div class="carousel-item" v-on:click="viewCake(cake)">
          <img class="carousel-item__img" :src="cake.image"/>
          <div class="carousel-item__details">
            <div class="controls">
              <i class="fa fa-birthday-cake" style="font-size:20px;color:white;"></i>
            </div>
            <h5 class="carousel-item__details--title">{{ cake.title }}</h5>
            <h6 class="carousel-item__details--subtitle"></h6>
          </div>
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
            this.$router.push({name:"Details",params:{id:cake.cake_id}})
        }
    },

}
</script>

<style scoped>

.carousel-item {
  width: 200px;
  height: 250px;
  border-radius: 10px;
  background-color: #95bcd6;
  overflow: hidden;
  margin-right: 40px;
  margin-left: 40px;
  margin-top: 70px;
  display: inline-block;
  cursor: pointer;
  -webkit-transition: 1000ms all;
  transition: 1000ms all;
  -webkit-transform-origin: center left;
  transform-origin: center left;
  position: relative;
  
}

.carousel-item:hover ~ .carousel-item {
 -webkit-transform: translate3d(100px, 0, 0);
  transform: translate3d(100px, 0, 0);
}



.carousel__container:hover .carousel-item:hover {
  -webkit-transform: scale(1.5);
  transform: scale(1.5);
  opacity: 1;
}

.carousel-item__img {
  width: 200px;
  height: 250px;
  -o-object-fit: cover;
  object-fit: cover;
}

.carousel-item__details {
  background: -webkit-gradient(linear, left bottom, left top,
    from(rgba(0, 0, 0, 0.9)),
    to(rgba(0, 0, 0, 0))
  );
  background: linear-gradient(
    to top,
    rgba(0, 0, 0, 0.9) 0%,
    rgba(0, 0, 0, 0) 100%
  );
  font-size: 10px;
  opacity: 0;
  -webkit-transition: 450ms opacity;
  transition: 450ms opacity;
  padding: 10px;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}

.carousel-item__details:hover {
  opacity: 1;
}

.carousel-item__details span {
  /* width: 10px;
  height: 10px; */
  font-size: 0.9rem;
  color: #2ecc71;
  /* background-color: white; */
}

.carousel-item__details .controls {
  padding-top: 180px;
}

.carousel-item__details .carousel-item__details--title,
.carousel-item__details--subtitle {
  color: #fff;
  margin: 5px 0;
}

</style>