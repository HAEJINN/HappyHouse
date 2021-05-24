<template>
  <div class="nav_wrap">
    <span v-if="isLogin">{{ userInfo.userid }}님 환영합니다</span>
    <div class="nav_item">
      <router-link to="/happyhouse/main" class="nav_link">메인</router-link>
      <router-link to="/happyhouse/searchApt" class="nav_link">아파트정보</router-link>
      <router-link to="/happyhouse/favoriteApt" class="nav_link">즐겨찾기</router-link>
      <router-link to="/happyhouse/myPage" class="nav_link">내정보</router-link>
      <button @click.prevent="onClickLogout" class="nav_link" v-if="isLogin">로그아웃</button>
    </div>
  </div>
</template>
<script>
import { mapState } from 'vuex';
export default {
  name: 'navi',
  computed: {
    ...mapState(['userInfo', 'isLogin']),
  },
  methods: {
    onClickLogout() {
      this.$store
        .dispatch('LOGOUT')
        .then(() => {
          // this.$router.push({ name: "" });
          if (this.$route.path !== '/') this.$router.replace('/');
        })
        .catch(() => {
          console.log('로그아웃 문제!!!');
        });
    },
  },
};
</script>
<style scoped>
.nav_wrap {
  display: flex;
  justify-content: flex-end;
  height: 8%;
  padding: 2.5em 0;
}
.nav_item {
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 27%;
  font-size: 1.3em;
}
.nav_link {
  text-decoration: none;
  color: inherit;
}
.nav_link:hover {
  font-weight: bold;
}
</style>
