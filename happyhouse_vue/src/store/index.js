import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";
import VueRouter from "vue-router";
// import jwt_decode from 'jwt-decode';
import { findById } from "@/api/user.js";

Vue.use(Vuex);
Vue.use(VueRouter);
export default new Vuex.Store({
  state: {
    notices: [],
    notice: null,
    posts: [],
    post: null,
    ranks: [],
    results: [],
    cctvs: [],
    convens: [],
    flist: [],
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
    cctvs(state) {
      return state.cctvs;
    },
    convens(state) {
      return state.convens;
    },
    userInfo(state) {
      return state.userInfo;
    },
    notice(state) {
      return state.notice;
    },
    post(state) {
      return state.post;
    },
    flist(state) {
      return state.flist;
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
    setCctvs(state, payload) {
      state.cctvs = payload;
    },
    setConven(state, payload) {
      state.convens = payload;
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
    setN(state, payload) {
      state.notice = payload;
    },
    setP(state, payload) {
      state.post = payload;
    },
    setFlist(state, payload) {
      state.flist = payload;
    },
  },
  actions: {
    getNotices(context) {
      http
        .get("/admin/board")
        .then(({ data }) => {
          context.commit("setNotices", data);
        })
        .catch(() => {
          // alert('에러발생');
        });
    },
    getPosts(context) {
      http
        .get("/board/")
        .then(({ data }) => {
          context.commit("setPosts", data);
        })
        .catch(() => {
          // alert('에러발생');
        });
    },
    getRanks(context) {
      http
        .get("/apt/toplist")
        .then(({ data }) => {
          context.commit("setRanks", data);
        })
        .catch(() => {
          // alert('에러발생');
        });
    },
    loadResult(context, data) {
      http
        .post("/apt/dong", data)
        .then(({ data }) => {
          console.log(data);
          context.commit("setResult", data);
        })
        .catch(() => {
          alert("????");
        });
    },
    loadResultbyApt(context, data) {
      console.log(data);
      http
        .post("/apt/name", data)
        .then(({ data }) => {
          console.log(data);
          context.commit("setResult", data);
        })
        .catch(() => {
          alert("????");
        });
    },
    loadResultbyDong(context, data) {
      http
        .post("/apt/dong", data)
        .then(({ data }) => {
          console.log(data);
          context.commit("setResult", data);
        })
        .catch(() => {
          alert("????");
        });
    },
    async GET_MEMBER_INFO(context) {
      await findById((response) => {
        //.log(response.data);
        context.commit("setUserInfo", response.data);
        // router.push("/");
        // router.go(router.currentRoute);
      });
    },
    LOGOUT({ commit }) {
      commit("logout");
      localStorage.removeItem("access-token");
      // axios.defaults.headers.common["auth-token"] = undefined;
      alert("로그아웃 되었습니다");
    },
    searchN(context, data) {
      console.log(data);
      http
        .get(`/admin/board/detail/${data}`)
        .then(({ data }) => {
          console.log("notice");
          context.commit("setN", data);
        })
        .catch(() => {
          alert("공지사항 로드 실패");
        });
    },
    searchP(context, data) {
      console.log(data);
      http
        .get(`/board/detail/${data}`)
        .then(({ data }) => {
          console.log("post");
          context.commit("setP", data);
        })
        .catch(() => {
          alert("게시물 로드 실패");
        });
    },
    async deleteP(context, data) {
      await http
        .delete(`/board/delete/${data}`)
        .then(({ data }) => {
          if (data === "SUCCESS") {
            alert("삭제성공");
            //this.$router.push('/happyhouse/postDetail');
          }
        })
        .catch(() => {
          alert("삭제실패");
          //this.$router.push('/happyhouse/postDetail');
        });
    },
    async deleteN(context, data) {
      await http
        .delete(`/admin/delete/${data}`)
        .then(({ data }) => {
          if (data === "SUCCESS") {
            alert("삭제성공");
            // this.$router.push('/happyhouse/noticeDetail');
          }
        })
        .catch(() => {
          alert("삭제실패");
          //this.$router.push('/happyhouse/noticeDetail');
        });
    },
    setSingleApt(context, favorite) {
      context.commit("setResult", [
        {
          aptname: favorite.aptname,
          lat: favorite.lat,
          lng: favorite.lng,
        },
      ]);
    },
    loadCctvs(context, favorite) {
      http
        .post("/pos/cctv", {
          lat: favorite.lat,
          lng: favorite.lng,
        })
        .then(({ data }) => {
          context.commit("setCctvs", data);
        })
        .catch(() => {
          alert("get cctv list error");
        });
    },
    loadConvens(context, favorite) {
      http
        .post("/pos/conven", {
          lat: favorite.lat,
          lng: favorite.lng,
        })
        .then(({ data }) => {
          context.commit("setConven", data);
        })
        .catch(() => {
          alert("get conven list error");
        });
    },
    clearMapData(context) {
      context.commit("setResult", []);
      context.commit("setCctvs", []);
      context.commit("setConven", []);
    },
    loadflist(context) {
      http
        .get("/user/favorite", {
          headers: {
            "access-token": window.localStorage.getItem("access-token"),
          },
        })
        .then(({ data }) => {
          context.commit("setFlist", data);
        })
        .catch(() => {
          alert("????");
        });
    },
    deletefavorite(context, no) {
      http
        .delete(`/user/favorite/${no}`, {
          headers: {
            "access-token": window.localStorage.getItem("access-token"),
          },
        })
        .then(({ data }) => {
          if (data === "SUCCESS") {
            context.commit("setFlist", []);
            console.log("즐겨찾기 삭제성공");
          }
        })
        .catch(() => {
          console.log("즐겨찾기 삭제실패");
        });
    },
  },
});
