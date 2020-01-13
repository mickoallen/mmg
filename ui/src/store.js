import Vue from 'vue'
import Vuex from 'vuex'
//import axios from "axios";
//import { SERVER_URL } from "./config.js";
//import router from './router';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user:{},
    game:{},
    players:[]
  },
  mutations: {
    gameCreated(state, createGameResponse) {
      state.user = createGameResponse.data.user;
      state.game = createGameResponse.data.game;
      
      state.players.push(state.user);
    }
  },
  actions: {

  },
  getters: {
  }
})
