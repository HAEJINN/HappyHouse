<!-- 공지사항 전체 목록 -->
<template>
  <div class="wrap">
    <h1 class="title">공지사항</h1>
    <div class="btndiv">
      <button v-if="userInfo.userid == 'admin'" @click="writePost">글작성</button>
    </div>
    <table class="table">
      <thead>
        <tr>
          <th class="th1">글번호</th>
          <th class="th1">글제목</th>
          <th class="th1">작성자</th>
          <th class="th2">작성시간</th>
          <th class="th3">내용</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(notice, idx) in notices" :key="idx" class="trs">
          <td class="td1">{{ notice.no }}</td>
          <td class="td1">
            <router-link :to="`noticeDesc?no=${notice.no}`" class="mvlink">{{
              notice.title
            }}</router-link>
          </td>
          <td class="td1">{{ notice.userid }}</td>
          <td class="td2">{{ notice.timestamp }}</td>
          <td class="td3">{{ notice.content }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import { mapGetters } from 'vuex';

export default {
  name: 'NoticeDetail',
  computed: {
    ...mapGetters(['userInfo', 'notices']),
  },
  created() {
    this.$store.dispatch('getNotices');
  },
  methods: {
    writePost() {
      this.$router.push('/happyhouse/noticeForm');
    },
  },
};
</script>
<style scoped>
.wrap {
  height: 100vh;
  width: 100%;
}
.title {
  text-align: center;
  font-size: 3em;
  margin-bottom: 0;
}
.table {
  font-size: 1.2em;
  width: 90%;
  margin: 0 auto;
  border-spacing: 0 20px;
  table-layout: fixed;
}
.btndiv {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 0.5em;
}
.btndiv button {
  width: 5em;
  height: 2em;
  font-size: 20px;
  margin-right: 3em;
}
.th1,
.td1 {
  width: 15%;
  text-align: center;
  text-overflow: ellipsis;
  overflow: hidden;
}
.th2,
.td2 {
  width: 20%;
  text-align: center;
  text-overflow: ellipsis;
  overflow: hidden;
}
.th3,
.td3 {
  width: 35%;
  text-align: center;
  text-overflow: ellipsis;
  overflow: hidden;
}
.th1,
.th2,
.th3 {
  background-color: #d3d3d3;
  padding: 10px 0;
}
.mvlink {
  text-decoration: none;
  color: blue;
}
.mvlink:hover {
  font-weight: bold;
}
</style>
