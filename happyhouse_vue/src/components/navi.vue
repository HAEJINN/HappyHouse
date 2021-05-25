<template>
  <div class="nav_wrap">
    <div v-if="userInfo">{{ userInfo.userid }}님 환영합니다</div>
    <div class="nav_item" v-if="userInfo">
      <router-link to="/happyhouse/main" class="nav_link">메인</router-link>
      <router-link to="/happyhouse/searchApt" class="nav_link">아파트정보</router-link>
      <router-link v-if="userInfo.userid == 'admin'" to="/happyhouse/dashboard" class="nav_link"
        >사이트통계</router-link
      >
      <router-link v-if="userInfo.userid != 'admin'" to="/happyhouse/favoriteApt" class="nav_link"
        >즐겨찾기</router-link
      >
      <router-link v-if="userInfo.userid != 'admin'" to="/happyhouse/myPage" class="nav_link"
        >내정보</router-link
      >
      <button @click.prevent="onClickLogout" class="nav_link" v-if="isLogin">로그아웃</button>
    </div>

    <!-- <div class="menu-btn" >
      <a class="menu-a" href="#"> <span class="menu-text">menu</span></a>
    </div>
    <nav class="navi">
      <div class="close-btn"></div>
      <h1 class="navi-title">MENU</h1>
      <ul class="navi-list">
        <li>
          <a href="#">Home</a>
        </li>
        <li>
          <a href="#">Ipsum veroeros</a>
        </li>
        <li>
          <a href="#">Tempus etiam</a>
        </li>
        <li>
          <a href="#">Consequat dolor</a>
        </li>
        <li>
          <a href="#">Elements</a>
        </li>
      </ul>
    </nav> -->
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

// var navi = document.querySelector('.navi');
// var menuBtn = document.querySelector('.menu-btn');
// var closeBtn = document.querySelector('.close-btn');

// menuBtn.addEventListener('click', function () {
//   navi.classList.add('navi-visible');
//   navi.classList.remove('navi-invisible');
// });

// closeBtn.addEventListener('click', function () {
//   navi.classList.add('navi-invisible');
//   navi.classList.remove('navi-visible');
// });
</script>
<style scoped>
.nav_wrap {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
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
/* .menu-btn {
  position: fixed;
  top: 15px;
  right: 15px;
  width: 40px;
  height: 40px;
  padding: 8px;
  z-index: 10;
  background-color: rgba(255, 255, 255, 0.5);
  border-radius: 5px;
}

.menu-text {
  position: absolute;
  z-index: -1000;
  width: 1px;
  height: 1px;
  visibility: hidden;
}

.menu-a::before {
  content: '';
  display: block;
  width: 100%;
  height: 100%;
  background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' width='100' height='100' viewBox='0 0 100 100' preserveAspectRatio='none'%3E%3Cstyle%3Eline %7B stroke-width: 8px%3B stroke: %23585858%3B %7D%3C/style%3E%3Cline x1='0' y1='25' x2='100' y2='25' /%3E%3Cline x1='0' y1='50' x2='100' y2='50' /%3E%3Cline x1='0' y1='75' x2='100' y2='75' /%3E%3C/svg%3E");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
}

.menu-a:hover::before {
  background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' width='100' height='100' viewBox='0 0 100 100' preserveAspectRatio='none'%3E%3Cstyle%3Eline %7B stroke-width: 8px%3B stroke: %23f2849e%3B %7D%3C/style%3E%3Cline x1='0' y1='25' x2='100' y2='25' /%3E%3Cline x1='0' y1='50' x2='100' y2='50' /%3E%3Cline x1='0' y1='75' x2='100' y2='75' /%3E%3C/svg%3E");
}

.navi {
  display: block;
  position: fixed;
  top: 0;
  right: -26.5em;
  width: 20em;
  height: 100vh;
  background-color: #585858;
  color: #ffffff;
  z-index: 10;
  padding: 2.5em;
  transition: right 1000ms;
}

.navi-visible {
  right: 0;
}

.navi-invisible {
  right: -26.5em;
}

.close-btn {
  display: block;
  position: absolute;
  background-image: url('../assets/close-b.png');
  background-size: cover;
  background-position: center center;
  width: 3em;
  height: 3em;
  top: 1em;
  left: -3.5em;
  cursor: pointer;
}

.close-btn:hover {
  background-image: url('../assets/close-p.png');
}

.navi-title {
  font-size: 1.5em;
  font-weight: 400;
  letter-spacing: 0.2em;
  margin-bottom: 1.5em;
}

.navi-list {
  font-size: 1em;
  font-weight: 300;
}

.navi-list li:hover {
  color: #db97d6;
}

.navi-list li::after {
  content: '';
  display: block;
  width: 100%;
  height: 1px;
  border-bottom: 1px solid #7d7d7d;
  margin: 1em 0;
}

.navi-list li:last-child::after {
  display: none;
} */
</style>
