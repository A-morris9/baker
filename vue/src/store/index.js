import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    cakes: [
      {
        name: "Classic Chocolate Cake",
        description: "Moist chocolate cake with rich chocolate frosting." ,
        price: "25.00" ,
        style: "Sheet Cake",
        size: "Medium",
        flavor: "Chocolate",
        filling: "None",
        availability: "true",
        image: 'https://img.taste.com.au/qrA0oF1O/taste/2016/11/classic-chocolate-cake-46019-1.jpeg'
      },
      {
        name: "Vanilla Celebration Cake",
        description: "Fluffy vanilla cake with colorful sprinkles and vanilla buttercream." ,
        price: "30.00" ,
        style: "Celebration",
        size: "Large",
        flavor: "Vanilla",
        filling: "Vanilla",
        availability: "true",
        image: 'https://cdn11.bigcommerce.com/s-w6rae6i8cu/images/stencil/1280x1280/products/115/785/PDP_lifestyle__0007_CELEB_9__96988__08613.1662993858.jpg?c=1'
      }
    ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
