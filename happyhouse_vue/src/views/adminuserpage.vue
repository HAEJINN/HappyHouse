<template lang="">
  <div class="wrap">
    <h1>사용자 관리</h1>
    <table class="table">
      <thead>
        <tr>
          <th class="th1">아이디</th>
          <th class="th2">이름</th>
          <th class="th1">이메일</th>
          <th class="th1">전화번호</th>
          <th class="th2">성별</th>
          <th class="th3">삭제</th>
        </tr>
      </thead>
      <tbody>
        <adminuser-list v-for="(user, idx) in userlist" :key="idx" :user="user" />
      </tbody>
    </table>
  </div>
</template>
<script>
import http from '@/util/http-common';
import AdminuserList from '@/components/items/adminuserList.vue';

export default {
  data() {
    return {
      userlist: [],
    };
  },
  components: {
    AdminuserList,
  },
  created() {
    http
      .get('/admin/user', {
        headers: {
          'access-token': window.localStorage.getItem('access-token'),
        },
      })
      .then(({ data }) => {
        this.userlist = data;
      })
      .catch(() => {
        // alert('에러발생');
      });
  },
};
</script>
<style scoped>
.wrap {
  width: 100%;
  height: 85vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.table {
  font-size: 1.2em;
  text-align: center;
  width: 90%;
  margin: 0 auto;
  border-spacing: 0 30px;
  table-layout: fixed;
}
.th1 {
  background-color: #d3d3d3;
  width: 20%;
  padding: 0.5em 0;
}
.th2 {
  background-color: #d3d3d3;
  width: 15%;
}
.th3 {
  background-color: #d3d3d3;
  width: 10%;
}
</style>
