<template>
  <div>
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
