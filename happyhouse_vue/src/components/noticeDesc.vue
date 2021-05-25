<template>
  <div v-if="notice">
    <h1>{{ notice.title }}</h1>
    <p>{{ notice.userid }}</p>
    <p>{{ notice.timestamp }}</p>
    <p>{{ notice.content }}</p>
    <button v-if="userInfo.userid == 'admin'" @click="modify">수정</button>
    <button v-if="userInfo.userid == 'admin'" @click="deleteN">삭제</button>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
export default {
  name: "NoticeDesc",
  computed: {
    ...mapGetters(["userInfo", "notice"]),
  },
  created() {
    this.$store.dispatch("searchN", this.$route.query.no);
  },
  methods: {
    modify() {
      this.$router.push("/happyhouse/updateNotice");
    },
    deleteN() {
      this.$store.dispatch("deleteN", this.$route.query.no);
      this.$router.push("/happyhouse/noticeDetail");
    },
  },
};
</script>
