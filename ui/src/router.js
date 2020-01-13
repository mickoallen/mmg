import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import StartGame from './views/StartGame.vue';
import JoinGame from './views/JoinGame.vue';
import Lobby from './views/Lobby.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/start*',
      component: StartGame
    },
    {
      path: '/join',
      component: JoinGame
    },
    {
      path: '/lobby',
      component: Lobby
    }
  ]
})
