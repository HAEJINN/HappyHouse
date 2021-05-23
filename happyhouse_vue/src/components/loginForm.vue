<template>
  <div>
    <h1>로그인</h1>
    <div>
      <label for="userid">아이디</label>
      <input type="text" id="userid" name="userid" ref="userid" v-model="userid" />
    </div>
    <div>
      <label for="userpwd">비밀번호</label>
      <input type="text" id="userpwd" name="userpwd" ref="userpwd" v-model="userpwd" />
    </div>
    <button @click="login">로그인</button>
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
