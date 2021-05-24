<template>
  <div class="post_wrap">
    <h1>postComp</h1>
    <post-item v-for="(post, idx) in posts" :key="idx" :post="post" />
    <router-link to="postDetail">post</router-link>
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
  width: 50%;
  border: 1px solid black;
  padding: 3em;
  margin: 0 3em;
}
</style>
