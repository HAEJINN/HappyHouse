<template>
  <div v-if="post">
    <h1>{{ post.title }}</h1>
    <p>{{ post.userid }}</p>
    <p>{{ post.timestamp }}</p>
    <p>{{ post.content }}</p>
    <button v-if="userInfo.userid == post.userid" @click="modify">수정</button>
    <button v-if="userInfo.userid == post.userid" @click="deleteP">삭제</button>
    <button @click="mvlist">목록</button>
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
  methods: {
    modify() {
      this.$router.push('/happyhouse/updatePost');
    },
    deleteP() {
      this.$store.dispatch('deleteP', this.$route.query.no);
      this.$router.push('/happyhouse/postDetail');
    },
    mvlist() {
      this.$router.push('/happyhouse/postDetail');
    },
  },
};
</script>
