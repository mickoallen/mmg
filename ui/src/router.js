import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import StartGame from './views/StartGame.vue';
import JoinGame from './views/JoinGame.vue';
import HostLobby from './views/HostLobby.vue';
import JoinLobby from './views/JoinLobby.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/start',
      component: StartGame
    },
    {
      path: '/join',
      component: JoinGame
    },
    {
      path: '/host-lobby',
      component: HostLobby
    },
    {
      path: '/join-lobby',
      component: JoinLobby
    },
    {
      path: '/game',
      component: JoinLobby
    }
  ]
})
