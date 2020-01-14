import Vue from 'vue'
import Vuex from 'vuex'
//import axios from "axios";
//import { SERVER_URL } from "./config.js";
//import router from './router';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {},
    game: {},
    players: []
  },
  mutations: {
    gameJoined(state, joinGameResponse) {
      state.user = joinGameResponse.data.user;
      state.game = joinGameResponse.data.game;


      joinGameResponse.data.game.users.forEach(user => {
        state.players.push(user);
      });

      //establish ws connection
    }
  },
  actions: {

  },
  getters: {
  }
})
