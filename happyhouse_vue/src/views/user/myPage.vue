<template>
  <div class="myPage">
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
      <button @click="deleteUser">탈퇴</button>
    </div>
  </div>
</template>
<script>
import { mapState } from 'vuex';
import http from '@/util/http-common';
export default {
  name: 'mypage',
  computed: {
    ...mapState(['userInfo', 'isLogin']),
  },
  methods: {
    deleteUser() {
      console.log('지우기');
      http
        .delete('/user/delete', {
          headers: {
            'access-token': window.localStorage.getItem('access-token'),
          },
        })
        .then(({ data }) => {
          console.log(data);
          if (data === 'SUCCESS') {
            alert('삭제성공');
            this.$router.push('/');
          }
        })
        .catch(() => {
          alert('삭제실패');
        });
    },
  },
};
</script>
<style scoped>
.myPage {
  width: 100%;
  height: 95vh;
}
</style>
