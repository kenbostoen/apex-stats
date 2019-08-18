import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Playerstats from './views/playerstats.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/search/:platform/:playername',
      name: 'playerstats',
      component: Playerstats
    }
  ]
})
