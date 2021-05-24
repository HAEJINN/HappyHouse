<template>
  <div class="login_wrap">
    <div class="login_form">
      <h1 class="login_title">로그인</h1>
      <div class="inputs">
        <div>
          <label for="userid">아이디</label>
          <input type="text" id="userid" name="userid" ref="userid" v-model="userid" />
        </div>
        <div>
          <label for="userpwd">비밀번호</label>
          <input type="text" id="userpwd" name="userpwd" ref="userpwd" v-model="userpwd" />
        </div>
      </div>
      <button @click="login" class="login_btn">로그인</button>
    </div>
  </div>
</template>
<script>
// import http from '@/util/http-common';
export default {
  name: 'registForm',
  props: {
    type: { type: String },
  },
  data() {
    return {
      userid: '',
      userpwd: '',
    };
  },
  methods: {
    login() {
      //   http
      //     .post('/api/board', {
      //       userid: this.userid,
      //       userpwd: this.userpwd,
      //     })
      //     .then(({ data }) => {
      //       console.log(data);
      //       let msg = '로그인 처리시 문제가 발생했습니다.';
      //       if (data === 'SUCCESS') {
      //         msg = '로그인이 완료되었습니다.';
      //       }
      //       alert(msg);
      //       this.mvList();
      //     })
      //     .catch(() => {
      //       alert('로그인 처리시 에러가 발생했습니다.');
      //     });
      this.mvMain();
    },
    mvMain() {
      this.$router.push('/happyhouse/main');
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
  width: 200px;
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
</style>
