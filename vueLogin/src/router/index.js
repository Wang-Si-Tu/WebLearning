import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import login from '@/views/login'
import mainInterface from '@/views/mainInterface'
import UserControl from "../components/UserControl"
import addUser from "../components/addUser";
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/mainInterface',
      name: 'mainInterface',
      component: mainInterface,
      children:[
        {
          path: '/UserControl',
          name: 'UserControl',
          component: UserControl
        },
        {
          path: '/addUser',
          name: 'addUser',
          component: addUser
        }
      ]
    }
  ]
})
