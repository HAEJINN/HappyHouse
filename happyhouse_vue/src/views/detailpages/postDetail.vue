<!-- 게시판 전체 목록 -->
<template>
  <div class="wrap">
    <h1 class="title">게시판</h1>
    <div class="btndiv">
      <button @click="writePost">글작성</button>
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
        <tr v-for="(post, idx) in posts" :key="idx">
          <td class="td1">{{ post.no }}</td>
          <td class="td1">
            <router-link :to="`postDesc?no=${post.no}`" class="mvlink">{{
              post.title
            }}</router-link>
          </td>
          <td class="td1">{{ post.userid }}</td>
          <td class="td2">{{ post.timestamp }}</td>
          <td class="td3">{{ post.content }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import { mapGetters } from 'vuex';

export default {
  name: 'PostDetail',
  computed: {
    ...mapGetters(['posts']),
  },
  created() {
    this.$store.dispatch('getPosts');
  },
  methods: {
    writePost() {
      this.$router.push('/happyhouse/postForm');
    },
  },
};
</script>
<style scoped>
.wrap {
  height: 80vh;
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
  border-spacing: 0 15px;
}
.btndiv {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 1em;
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
}
.th2,
.td2 {
  width: 20%;
  text-align: center;
}
.th3,
.td3 {
  width: 35%;
  text-align: center;
}
.th1,
.th2,
.th3 {
  background-color: #fbe3fd;
  padding: 10px 0;
}
.mvlink {
  text-decoration: none;
  color: blue;
}
.mvlink:hover {
  font-size: 110%;
}
</style>
