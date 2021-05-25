<template>
  <div class="login_wrap">
    <div class="login_form">
      <h1 class="login_title">로그인</h1>
      <div class="inputs">
        <div class="input_wrap">
          <label for="userid">아이디</label>
          <input type="text" id="userid" name="userid" ref="userid" v-model="user.userid" />
        </div>
        <div class="input_wrap">
          <label for="userpwd">비밀번호</label>
          <input
            type="password"
            id="userpwd"
            name="userpwd"
            ref="userpwd"
            @keyup.enter="confirm"
            v-model="user.userpwd"
          />
        </div>
      </div>
      <button @click="confirm" class="login_btn">로그인</button>
    </div>
  </div>
</template>
<script>
import { login } from '@/api/user.js';
// import http from '@/util/http-common';
export default {
  name: 'registForm',
  props: {
    type: { type: String },
  },
  data() {
    return {
      user: {
        userid: null,
        userpwd: null,
      },
      isLoginError: false,
    };
  },
  methods: {
    confirm() {
      localStorage.setItem('access-token', '');
      login(
        this.user,
        (response) => {
          if (response.data.message === 'SUCCESS') {
            let token = response.data['access-token'];
            this.$store.commit('setIsLogined', true);
            localStorage.setItem('access-token', token);

            this.$store.dispatch('GET_MEMBER_INFO', token);
            this.$router.push('/happyhouse/main');
          } else {
            this.isLoginError = true;
          }
        },
        (error) => {
          console.error(error);
          alert('아이디 또는 비밀번호가 일치하지 않습니다.');
        }
      );
    },
  },
};
</script>
<style scoped>
.login_wrap {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100vh;
}
.login_form {
  display: flex;
  position: absolute;
  flex-direction: column;
  justify-content: center;
  width: 27%;
  height: 40%;
  border-radius: 2em;
  overflow: hidden;
  color: #ffffff;
}
.login_form::after {
  display: block;
  position: absolute;
  content: '';
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  background-color: #404040;
  opacity: 0.85;
  z-index: -1;
}
.login_title {
  margin: 0;
  margin-bottom: 1em;
  font-size: 2.5em;
  letter-spacing: 5px;
  text-align: center;
}
.inputs {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.login_form div label {
  margin-right: 0.5em;
  font-size: 1.3em;
  line-height: 1.5;
}
.login_form div input {
  margin-bottom: 1.5em;
  height: 2.5em;
}
.login_btn {
  display: block;
  margin: 0 auto;
  margin-top: 1em;
  width: 6.5em;
  height: 2.5em;
  font-size: 1.1em;
  border: none;
  border-radius: 10px;
}
.login_btn:hover {
  cursor: pointer;
  transform: scale(1.05);
}
.input_wrap {
  display: flex;
  width: 60%;
  margin: 0 auto;
}
.input_wrap label {
  display: block;
  width: 30%;
}
.input_wrap input {
  display: block;
  width: 70%;
}
</style>
