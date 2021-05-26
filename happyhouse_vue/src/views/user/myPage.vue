<template>
  <div class="myPage">
    <h1>내정보</h1>
    <table class="table">
      <tr class="tr">
        <th class="th">아이디</th>
        <td class="td">{{ userInfo.userid }}</td>
      </tr>
      <tr class="tr">
        <th class="th">이름</th>
        <td class="td">{{ userInfo.username }}</td>
      </tr>
      <tr class="tr">
        <th class="th">비밀번호</th>
        <td class="td">{{ userInfo.userpwd }}</td>
      </tr>
      <tr class="tr">
        <th class="th">이메일</th>
        <td class="td">{{ userInfo.email }}</td>
      </tr>
      <tr class="tr">
        <th class="th">전화번호</th>
        <td class="td">{{ userInfo.phonenumber }}</td>
      </tr>
      <tr class="tr">
        <th class="th">성별</th>
        <td class="td">{{ userInfo.gender }}</td>
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
h1 {
  text-align: center;
}
.myPage {
  width: 100%;
  height: 80vh;
}
.tr {
  display: flex;
}
.th {
  display: block;
  width: 50%;
}
.td {
  display: block;
  width: 50%;
}
.table {
  display: block;
  width: 90%;
  margin: 0 auto;
}
</style>
