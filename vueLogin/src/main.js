// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'
import axios from 'axios'
import sideBar from "./components/sideBar";
Vue.component('sideBar', sideBar);
Vue.use(ElementUI)
Vue.prototype.$axios=axios
axios.defaults.baseURL='http://localhost:8888/api'
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {
    App,
    sideBar
  },
  template: '<App/>'
})
