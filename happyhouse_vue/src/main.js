import Vue from "vue";
import App from "./App.vue";
import store from "./store";
import router from "./router";
import VueTyperPlugin from "vue-typer";

Vue.config.productionTip = false;
Vue.use(VueTyperPlugin);

new Vue({
  router,
  store,
  async beforeCreate() {
    let token = localStorage.getItem("access-token");
    if (store.state.userInfo == null && token) {
      await store.dispatch("GET_MEMBER_INFO", token);
    }
  },
  render: (h) => h(App),
}).$mount("#app");

import * as VueGoogleMaps from "vue2-google-maps";

Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyDJhCuscXPRq8z1m3yBFo0WosSf3Hcpzm0",
    libraries: "places",
  },
});
