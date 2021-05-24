import Vue from 'vue';
import App from './App.vue';
import store from './store';
import router from './router';

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  async beforeCreate() {
    let token = localStorage.getItem('access-token');
    if (store.state.userInfo == null && token) {
      await store.dispatch('GET_MEMBER_INFO', token);
    }
  },
  render: (h) => h(App),
}).$mount('#app');
