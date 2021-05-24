<template>
  <div class="post_wrap">
    <h1 class="post_title">게시판</h1>
    <router-link to="postDetail" class="detail_link">더보기</router-link>
    <post-item v-for="(post, idx) in posts" :key="idx" :post="post" />
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
  border: 1px solid black;
  padding: 1em;
  margin: 0 1em;
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
