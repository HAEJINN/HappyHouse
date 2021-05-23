import Vue from 'vue';
import Vuex from 'vuex';
import http from '@/util/http-common';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    notices: [],
    posts: [],
    ranks: [],
    results: [],
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
    }
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
    setResult(state, payload){
      state.results = payload;
    }
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
    loadResult(context, data){
      http
      .post('/apt/dong', data)
      .then(({data})=> {
        console.log(data);
        context.commit("setResult", data);
      })
      .catch(() => {
        alert("????");
      });
    },
    loadResultbyApt(context, data){
      console.log(data);
      http
      .post('/apt/name', data)
      .then(({data})=> {
        console.log(data);
        context.commit("setResult", data);
      })
      .catch(() => {
        alert("????");
      });
    },
    loadResultbyDong(context, data){
      http
      .post('/apt/dong', data)
      .then(({data})=> {
        console.log(data);
        context.commit("setResult", data);
      })
      .catch(() => {
        alert("????");
      });
    }
  },
});
