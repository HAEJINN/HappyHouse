<!-- 게시판 전체 목록 -->
<template>
  <div>
    <h1>게시판</h1>
    <button @click="writePost">글작성</button>
    <table>
      <thead>
        <tr>
          <th>글번호</th>
          <th>글제목</th>
          <th>작성자</th>
          <th>작성시간</th>
          <th>내용</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(post, idx) in posts" :key="idx">
          <td>{{ post.no }}</td>
          <td>
            <router-link :to="`postDesc?no=${post.no}`">{{ post.title }}</router-link>
          </td>
          <td>{{ post.userid }}</td>
          <td>{{ post.timestamp }}</td>
          <td>{{ post.content }}</td>
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
