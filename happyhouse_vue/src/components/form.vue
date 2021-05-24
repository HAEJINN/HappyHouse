<template>
  <div class="regist_wrap">
    <div class="regist_form">
      <!-- <h1 v-if="isLogin">정보 수정</h1> -->
      <h1 v-if="type == 'update'">정보 수정</h1>

      <h1 v-else>회원가입</h1>
      <div>
        <label for="userid">아이디</label>
        <input v-if="type == 'update'" v-model="userid" disabled />
        <input v-else type="text" id="userid" name="userid" v-model="userid" />
      </div>
      <div>
        <label for="username">이름</label>
        <input type="text" id="username" name="username" v-model="username" />
      </div>
      <div>
        <label for="userpwd">비밀번호</label>
        <input type="password" id="userpwd" name="userpwd" v-model="userpwd" />
      </div>
      <div>
        <label for="email">이메일</label>
        <input type="text" id="email" name="email" v-model="email" />
      </div>
      <div>
        <label for="phonenumber">전화번호</label>
        <input
          type="text"
          id="phonenumber"
          name="phonenumber"
          ref="phonenumber"
          v-model="phonenumber"
        />
      </div>
      <div>
        <label for="gender">성별</label>
        <select name="gender" id="gender" v-model="gender">
          <option v-for="(type, idx) in types" :key="idx">{{ type }}</option>
        </select>
      </div>
      <button v-if="type == 'update'" @click="modify" class="regist_btn">수정</button>
      <button v-else @click="regist" class="regist_btn">가입</button>
    </div>
  </div>
</template>
<script>
import http from '@/util/http-common';
import { mapState } from 'vuex';

export default {
  name: 'registForm',
  props: {
    type: { type: String },
  },
  computed: {
    ...mapState(['userInfo', 'isLogin']),
  },
  data() {
    return {
      types: ['남자', '여자'],
      userid: '',
      username: '',
      userpwd: '',
      email: '',
      phonenumber: '',
      gender: '',
    };
  },
  created() {
    if (this.type === 'update') {
      this.$store.dispatch('GET_MEMBER_INFO');
      // console.log(this.userInfo);
      // http.get('/user/detail').then(({ response }) => {
      this.userid = this.userInfo.userid;
      this.username = this.userInfo.username;
      this.userpwd = this.userInfo.userpwd;
      this.email = this.userInfo.email;
      this.phonenumber = this.userInfo.phonenumber;
      this.gender = this.userInfo.gender;
      // console.log(response);
      // });
    }
  },
  methods: {
    regist() {
      http
        .post('/user/', {
          userid: this.userid,
          username: this.username,
          userpwd: this.userpwd,
          email: this.email,
          phonenumber: this.phonenumber,
          gender: this.gender,
        })
        .then(({ data }) => {
          console.log(data);
          let msg = '가입시 문제가 발생했습니다.';
          if (data === 'SUCCESS') {
            msg = '가입이 완료되었습니다.';
          }
          alert(msg);
          this.mvMain();
        })
        .catch(() => {
          alert('가입시 에러가 발생했습니다.');
          this.mvMain();
        });
    },
    modify() {
      http
        .put('/user/update', {
          userid: this.userid,
          username: this.username,
          userpwd: this.userpwd,
          email: this.email,
          phonenumber: this.phonenumber,
          gender: this.gender,
        })
        .then(({ data }) => {
          console.log(data);
          let msg = '수정 처리시 문제가 발생했습니다.';
          if (data.message === 'SUCCESS') {
            msg = '수정이 완료되었습니다.';
            let token = data['access-token'];
            localStorage.setItem('access-token', token);
            this.$store.dispatch('GET_MEMBER_INFO');
          }
          alert(msg);

          this.$router.push('/happyhouse/myPage');
        })
        .catch(() => {
          alert('수정 처리시 에러가 발생했습니다.');
          this.$router.push('/happyhouse/myPage');
        });
    },
    mvMain() {
      this.$router.push('/');
    },
  },
};
</script>
<style lang="postcss" scoped>
.regist_wrap {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100vh;
}
.regist_form {
  display: flex;
  position: absolute;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 30%;
  height: 65%;
  border-radius: 2em;
  overflow: hidden;
  color: #ffffff;
  font-size: 1.3em;
}
.regist_form::after {
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
.regist_form div {
  margin-bottom: 1.5em;
}
.regist_form div label {
  margin-right: 1em;
}
.regist_form div input {
  width: 200px;
  height: 2.5em;
}
.regist_form div select {
  width: 200px;
  font-size: 1.02em;
  height: 1.5em;
}
.regist_btn {
  width: 20%;
  font-size: 1.05em;
  height: 1.8em;
  margin-bottom: 1em;
}
</style>
