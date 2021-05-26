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
    news: [],
    cctvs: [],
    convens: [],
    cafes: [],
    phars: [],
    buss: [],
    trains: [],
    flist: [],
    statics: {},
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
    news(state) {
      return state.news;
    },
    cctvs(state) {
      return state.cctvs;
    },
    convens(state) {
      return state.convens;
    },
    cafes(state) {
      return state.cafes;
    },
    phars(state) {
      return state.phars;
    },
    buss(state) {
      return state.buss;
    },
    trains(state) {
      return state.trains;
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
    statics(state) {
      return state.statics;
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
    setNews(state, payload) {
      state.news = payload;
    },
    setCctvs(state, payload) {
      state.cctvs = payload;
    },
    setConvens(state, payload) {
      state.convens = payload;
    },
    setCafes(state, payload) {
      state.cafes = payload;
    },
    setPhars(state, payload) {
      state.phars = payload;
    },
    setBuss(state, payload) {
      state.buss = payload;
    },
    setTrains(state, payload) {
      state.trains = payload;
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
    setstatics(state, payload) {
      state.statics = payload;
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
    getNews(context) {
      http
        .get("/apt/news")
        .then(({ data }) => {
          context.commit("setNews", data);
        })
        .catch(() => {
          // alert('에러발생');
        });
    },
    loadResult(context, data) {
      http
        .post("/apt/dong", data)
        .then(({ data }) => {
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
          alert("근처에 cctv가 없습니다.");
        });
    },
    loadConvens(context, favorite) {
      http
        .post("/pos/conven", {
          lat: favorite.lat,
          lng: favorite.lng,
        })
        .then(({ data }) => {
          context.commit("setConvens", data);
        })
        .catch(() => {
          alert("근처에 편의점이 없습니다.");
        });
    },
    loadCafes(context, favorite) {
      http
        .post("/pos/cafe", {
          lat: favorite.lat,
          lng: favorite.lng,
        })
        .then(({ data }) => {
          context.commit("setCafes", data);
        })
        .catch(() => {
          alert("근처에 카페가 없습니다.");
        });
    },
    loadPhars(context, favorite) {
      http
        .post("/pos/phar", {
          lat: favorite.lat,
          lng: favorite.lng,
        })
        .then(({ data }) => {
          context.commit("setPhars", data);
        })
        .catch(() => {
          alert("근처에 약국이 없습니다.");
        });
    },
    loadBuss(context, favorite) {
      http
        .post("/pos/bus", {
          lat: favorite.lat,
          lng: favorite.lng,
        })
        .then(({ data }) => {
          context.commit("setBuss", data);
        })
        .catch(() => {
          alert("근처에 버스정류장이 없습니다.");
        });
    },
    loadTrains(context, favorite) {
      http
        .post("/pos/train", {
          lat: favorite.lat,
          lng: favorite.lng,
        })
        .then(({ data }) => {
          context.commit("setTrains", data);
        })
        .catch(() => {
          alert("근처에 지하철역이 없습니다.");
        });
    },
    clearMapData(context) {
      context.commit("setResult", []);
      context.commit("setCctvs", []);
      context.commit("setConvens", []);
      context.commit("setCafes", []);
      context.commit("setPhars", []);
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
    loadstatics(context) {
      http
        .get("/admin/static")
        .then(({ data }) => {
          context.commit("setstatics", data);
        })
        .catch(() => {
          alert("static load error");
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
