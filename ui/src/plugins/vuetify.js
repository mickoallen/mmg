import Vue from 'vue';
import Vuetify from 'vuetify/lib';


Vue.use(
  Vuetify
);

export default new Vuetify({
  theme: {
    themes: {
      dark: {
        primary: '#156eac',
        secondary: '#f6575e',
        accent: '#8c9eff',
        error: '#b71c1c',
      },
      light: {
        primary: '#156eac',
        secondary: '#f6575e',
        accent: '#8c9eff',
        error: '#b71c1c',
      },
    },
  },
  dark: true,
  icons: {
    iconfont: 'mdi',
  }
});