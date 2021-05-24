import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/home.vue'; // 접속 화면
import Login from '@/views/user/login.vue'; // 로그인
import Regist from '@/views/user/regist.vue'; // 회원가입
import HappyHouse from '@/views/happyHouse.vue'; // 메인화면

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
  },
  {
    path: '/regist',
    name: 'Regist',
    component: Regist,
  },
  {
    path: '/update',
    name: 'Update',
    component: () => import('@/views/user/update.vue'),
  },
  {
    path: '/resultComp',
    name: 'result-comp',
    component: () => import('@/views/aptpages/resultComp.vue'),
  },
  {
    path: '/happyhouse',
    name: 'happyhouse',
    component: HappyHouse,
    children: [
      {
        path: 'main',
        name: 'content',
        component: () => import('@/views/content.vue'),
      },
      {
        path: 'searchApt',
        name: 'search-apt',
        component: () => import('@/views/aptpages/searchApt.vue'),
      },
      {
        path: 'favoriteApt',
        name: 'favorite-apt',
        component: () => import('@/views/aptpages/favoriteApt.vue'),
      },
      {
        path: 'myPage',
        name: 'my-page',
        component: () => import('@/views/user/myPage.vue'),
      },
      {
        path: 'noticeDetail',
        name: 'notice-detail',
        component: () => import('@/views/detailpages/noticeDetail.vue'),
      },
      {
        path: 'postDetail',
        name: 'post-detail',
        component: () => import('@/views/detailpages/postDetail.vue'),
      },
      {
        path: 'newsDetail',
        name: 'news-detail',
        component: () => import('@/views/detailpages/newsDetail.vue'),
      },
    ],
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
