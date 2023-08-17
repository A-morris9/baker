import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import VCalendar from 'v-calendar';

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

Vue.use(VCalendar, {
  componentPrefix: 'vc',
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
