<template>
  <div class="post_wrap">
    <h1 class="post_title">게시판</h1>
    <div class="btn_div">
      <router-link to="postDetail" class="detail_link">더보기</router-link>
    </div>
    <table class="table">
      <thead>
        <tr class="tr">
          <th class="th1">글번호</th>
          <th class="th1">글제목</th>
          <th class="th1">작성자</th>
          <th class="th2">작성시간</th>
        </tr>
      </thead>
      <tbody>
        <post-item v-for="(post, idx) in posts" :key="idx" :post="post" />
      </tbody>
    </table>
  </div>
</template>
<script>
import PostItem from '@/components/items/postItem.vue';

import { mapGetters } from 'vuex';
export default {
  name: 'PostComp',
  components: { PostItem },

  computed: {
    ...mapGetters(['posts']),
  },
  created() {
    this.$store.dispatch('getPosts');
  },
};
</script>
<style scoped>
.post_wrap {
  /* background-color: blanchedalmond; */
  margin-bottom: 50px;
  width: calc(50% - 0.5px);
}
.post_title {
  text-align: center;
  font-size: 1.5em;
  margin: 0;
}
.btn_div {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 20px;
}
.detail_link {
  text-decoration: none;
  font-size: 0.8em;
  color: blue;
}
.detail_link:hover {
  font-weight: bold;
}
.table {
  width: 100%;
  border-spacing: 0 10px;
}
.th1 {
  width: 20%;
}
.th2 {
  width: 40%;
}
</style>
