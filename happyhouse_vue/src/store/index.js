import Vue from 'vue';
import Vuex from 'vuex';
import http from '@/util/http-common';
// import jwt_decode from 'jwt-decode';
import { findById } from '@/api/user.js';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    notices: [],
    posts: [],
    ranks: [],
    results: [],
    isLogin: false, // 로그인 여부
    userInfo: null,
  },
  getters: {
    notices(state) {
      return state.notices;
    },
    posts(state) {
      return state.posts;
    },
    ranks(state) {
      return state.ranks;
    },
    results(state) {
      return state.results;
    },
  },
  mutations: {
    setNotices(state, payload) {
      state.notices = payload;
    },
    setPosts(state, payload) {
      state.posts = payload;
    },
    setRanks(state, payload) {
      state.ranks = payload;
    },
    setResult(state, payload) {
      state.results = payload;
    },
    setIsLogined(state, isLogin) {
      state.isLogin = isLogin;
    },
    setUserInfo(state, userInfo) {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
    logout(state) {
      state.isLogin = false;
      state.userInfo = null;
    },
  },
  actions: {
    getNotices(context) {
      http
        .get('/admin/board')
        .then(({ data }) => {
          context.commit('setNotices', data);
        })
        .catch(() => {
          // alert('에러발생');
        });
    },
    getPosts(context) {
      http
        .get('/board/')
        .then(({ data }) => {
          context.commit('setPosts', data);
        })
        .catch(() => {
          // alert('에러발생');
        });
    },
    getRanks(context) {
      http
        .get('/apt/toplist')
        .then(({ data }) => {
          context.commit('setRanks', data);
        })
        .catch(() => {
          // alert('에러발생');
        });
    },
    loadResult(context, data) {
      http
        .post('/apt/dong', data)
        .then(({ data }) => {
          console.log(data);
          context.commit('setResult', data);
        })
        .catch(() => {
          alert('????');
        });
    },
    loadResultbyApt(context, data) {
      console.log(data);
      http
        .post('/apt/name', data)
        .then(({ data }) => {
          console.log(data);
          context.commit('setResult', data);
        })
        .catch(() => {
          alert('????');
        });
    },
    loadResultbyDong(context, data) {
      http
        .post('/apt/dong', data)
        .then(({ data }) => {
          console.log(data);
          context.commit('setResult', data);
        })
        .catch(() => {
          alert('????');
        });
    },
    // async GET_MEMBER_INFO({ commit }, token) {
    //   let decode = jwt_decode(token);

    //   await findById(
    //     decode.userid,
    //     (response) => {
    //       // if (response.data.message === 'SUCCESS') {
    //       //   commit('setUserInfo', response.data.userInfo);
    //       //   // router.push("/");
    //       //   // router.go(router.currentRoute);
    //       // } else {
    //       //   console.log('유저 정보 없음!!');
    //       // }
    //       commit('setUserInfo', response.data.userInfo);

    //     },
    //     (error) => {
    //       console.log(error);
    //     }
    //   );
    // },
    async GET_MEMBER_INFO(context) {
      await findById((response) => {
        context.commit('setUserInfo', response);
        // router.push("/");
        // router.go(router.currentRoute);
      });
    },

    LOGOUT({ commit }) {
      commit('logout');
      localStorage.removeItem('access-token');
      // axios.defaults.headers.common["auth-token"] = undefined;
    },
  },
});
