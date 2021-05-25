<template>
  <div class="post_wrap">
    <h1 class="post_title">게시판</h1>
    <router-link to="postDetail" class="detail_link">더보기</router-link>
    <table>
      <thead>
        <tr>
          <th>글번호</th>
          <th>글제목</th>
          <th>작성자</th>
          <th>작성시간</th>
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
  background-color: blanchedalmond;
  padding: 1em;
  margin-bottom: 50px;
  margin-left: 5px;
}
.post_title {
  text-align: center;
  font-size: 1.5em;
}
.detail_link {
  position: relative;
  bottom: 0;
  right: 0;
}
</style>
