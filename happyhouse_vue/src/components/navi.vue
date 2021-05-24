<template>
  <div class="nav_wrap">
    <div class="nav_item">
      <router-link to="/happyhouse/main" class="nav_link">메인</router-link>
      <router-link to="/happyhouse/searchApt" class="nav_link">아파트정보</router-link>
      <router-link to="/happyhouse/favoriteApt" class="nav_link">즐겨찾기</router-link>
      <router-link to="/happyhouse/myPage" class="nav_link">내정보</router-link>
    </div>
  </div>
</template>
<script>
export default {
  name: 'navi',
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
  font-size: 1.1em;
}
</style>
