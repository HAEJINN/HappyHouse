<template>
  <div>
    <h1>내정보</h1>
    <table>
      <tr>
        <th>아이디</th>
        <td>{{ userInfo.userid }}</td>
      </tr>
      <tr>
        <th>이름</th>
        <td>{{ userInfo.username }}</td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td>{{ userInfo.userpwd }}</td>
      </tr>
      <tr>
        <th>이메일</th>
        <td>{{ userInfo.email }}</td>
      </tr>
      <tr>
        <th>전화번호</th>
        <td>{{ userInfo.phonenumber }}</td>
      </tr>
      <tr>
        <th>성별</th>
        <td>{{ userInfo.gender }}</td>
      </tr>
    </table>
    <div class="text-center">
      <router-link to="/happyhouse/main"><button>메인</button></router-link>
      <router-link to="/update"><button>수정</button></router-link>
      <router-link to="/delete"><button>삭제</button></router-link>
    </div>
  </div>
</template>
<script>
import { mapState } from 'vuex';
export default {
  name: 'mypage',
  computed: {
    ...mapState(['userInfo', 'isLogin']),
  },

  // created() {
  //   console.log('수정?');
  //   this.$store.dispatch('GET_MEMBER_INFO');
  //   // console.log(this.userInfo);
  //   // this.userid = this.userInfo.userid;
  //   // this.username = this.userInfo.username;
  //   // this.userpwd = this.userInfo.userpwd;
  //   // this.email = this.userInfo.email;
  //   // this.phonenumber = this.userInfo.phonenumber;
  //   // this.gender = this.userInfo.gender;
  // },
};
</script>
