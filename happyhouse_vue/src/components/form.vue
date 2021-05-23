<template>
  <div>
    <h1>회원가입</h1>
    <div>
      <label for="userid">아이디</label>
      <input type="text" id="userid" name="userid" v-model="userid" />
    </div>
    <div>
      <label for="username">이름</label>
      <input type="text" id="username" name="username" v-model="username" />
    </div>
    <div>
      <label for="userpwd">비밀번호</label>
      <input type="text" id="userpwd" name="userpwd" v-model="userpwd" />
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
    <button v-if="type == 'update'" @click="update">수정</button>
    <button v-else @click="regist">가입</button>
  </div>
</template>
<script>
// import http from '@/util/http-common';
export default {
  name: "registForm",
  props: {
    type: { type: String },
  },
  data() {
    return {
      types: ["남자", "여자"],
      userid: "",
      username: "",
      userpwd: "",
      email: "",
      phonenumber: "",
      gender: "",
    };
  },
  // created() {
  //   if (this.type === 'update') {
  //     http.get(`/${this.$route.params.isbn}`).then(({ data }) => {
  //       this.userid = data.userid;
  //       this.username = data.username;
  //       this.userpwd = data.userpwd;
  //       this.email = data.email;
  //       this.phonenumber = data.phonenumber;
  //       this.gender = data.gender;
  //     });
  //   }
  // },
  methods: {
    regist() {
      //   http
      //     .post('/api/board', {
      //       userid: this.userid,
      //       username: this.username,
      //       userpwd: this.userpwd,
      //       email: this.email,
      //       phonenumber: this.phonenumber,
      //       gender: this.gender,
      //     })
      //     .then(({ data }) => {
      //       console.log(data);
      //       let msg = '등록 처리시 문제가 발생했습니다.';
      //       if (data === 'SUCCESS') {
      //         msg = '등록이 완료되었습니다.';
      //       }
      //       alert(msg);
      //       this.mvMain();
      //     })
      //     .catch(() => {
      //       alert('등록 처리시 에러가 발생했습니다.');
      //     });
      this.mvMain();
    },
    modify() {
      // http
      //   .put('/api/board', {
      //    userid: this.userid,
      //       username: this.username,
      //       userpwd: this.userpwd,
      //       email: this.email,
      //       phonenumber: this.phonenumber,
      //       gender: this.gender,
      //   })
      //   .then(({ data }) => {
      //     console.log(data);
      //     let msg = '수정 처리시 문제가 발생했습니다.';
      //     if (data.state === 'succ') {
      //       msg = '수정이 완료되었습니다.';
      //     }
      //     alert(msg);
      //     this.mvMain();
      //   })
      //   .catch(() => {
      //     alert('수정 처리시 에러가 발생했습니다.');
      //   });
      this.mvMain();
    },
    mvMain() {
      this.$router.push("/happyhouse/main");
    },
  },
};
</script>
