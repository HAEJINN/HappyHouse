<!-- 실행 후 첫 화면 -->
<template>
  <div class="main_wrap">
    <div></div>
    <div class="main_cover">
      <vue-typer class="main_title" text="HAPPY HOUSE" erase-style="clear"></vue-typer>
      <h1 class="main_title">HAPPY HOUSE</h1>
      <div class="main_btns">
        <router-link to="/login" class="login_btn">로그인</router-link>
        <router-link to="/regist" class="regist_btn">회원가입</router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>
<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
}

.main_wrap {
  display: flex;
  height: 100vh;
}
.main_wrap::after {
  display: block;
  position: absolute;
  content: "";
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  background-image: url("../../src/assets/main_house.jpg");
  background-size: cover;
  opacity: 0.8;
  z-index: -100;
}
.main_wrap div:first-child {
  width: 63%;
  height: 100vh;
}
.main_cover {
  display: flex;
  position: absolute;
  right: 0;
  flex-direction: column;
  justify-content: center;
  width: 37%;
  height: 100vh;
  color: #ffffff;
}
.main_cover::after {
  display: block;
  position: absolute;
  content: "";
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  background-color: #404040;
  opacity: 0.85;
  z-index: -10;
}
.main_title {
  text-align: center;
  font-size: 4em;
  margin-bottom: 2em;
  letter-spacing: 0.05em;
}
.main_btns {
  display: flex;
  justify-content: center;
}
.login_btn,
.regist_btn {
  text-decoration: none;
  font-size: 1.2em;
  color: inherit;
  border: 1.5px solid #ffffff;
  padding: 0.6em 1.8em;
  margin: 0 1em;
  border-radius: 30px;
  letter-spacing: 0.05em;
}
.login_btn:hover,
.regist_btn:hover {
  border: none;
  background-color: #404040;
  transform: scale(1.1);
}
</style>
