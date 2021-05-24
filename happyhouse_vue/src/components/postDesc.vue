<template>
  <div v-if="post">
    <h1>{{ post.title }}</h1>
    <p>{{ post.userid }}</p>
    <p>{{ post.timestamp }}</p>
    <p>{{ post.content }}</p>
    <button v-if="userInfo.userid == post.userid">수정</button>
  </div>
</template>
<script>
import { mapGetters } from 'vuex';
export default {
  name: 'PostDesc',
  computed: {
    ...mapGetters(['userInfo', 'post']),
  },
  created() {
    this.$store.dispatch('searchP', this.$route.query.no);
  },
};
</script>
