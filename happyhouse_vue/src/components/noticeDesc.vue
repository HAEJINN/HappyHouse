<template>
  <div v-if="notice" class="wrap">
    <div class="title_wrap">
      <h1 class="title">{{ notice.title }}</h1>
    </div>
    <div class="writer">
      <p>{{ notice.userid }}</p>
    </div>
    <div class="contentwrap">
      <div class="timestamp">
        <p>{{ notice.timestamp }}</p>
      </div>
      <div class="desc">
        <p>{{ notice.content }}</p>
      </div>
    </div>
    <did class="btns">
      <button v-if="userInfo.userid == 'admin'" @click="modify">수정</button>
      <button v-if="userInfo.userid == 'admin'" @click="deleteN">삭제</button>
      <button @click="mvlist">목록</button>
    </did>
  </div>
</template>
<script>
import { mapGetters } from 'vuex';
export default {
  name: 'NoticeDesc',
  computed: {
    ...mapGetters(['userInfo', 'notice']),
  },
  created() {
    this.$store.dispatch('searchN', this.$route.query.no);
  },
  methods: {
    modify() {
      this.$router.push('/happyhouse/updateNotice');
    },
    deleteN() {
      this.$store.dispatch('deleteN', this.$route.query.no);
      this.$router.push('/happyhouse/noticeDetail');
    },
    mvlist() {
      this.$router.push('/happyhouse/noticeDetail');
    },
  },
};
</script>
<style scoped>
.wrap {
  width: 100%;
  height: 80vh;
}
.title_wrap {
  width: 40%;
  margin: 3em auto 0;
  background-color: #d3d3d3;
  padding: 0.1em 0;
  border-radius: 10px;
}
.title {
  text-align: center;
}
.writer {
  display: flex;
  justify-content: flex-end;
}
.writer p {
  margin: 0;
  font-size: 2em;
  margin-right: 5em;
}
.contentwrap {
  display: flex;
  flex-direction: column;
  border: 2px solid #d3d3d3;
  width: 70%;
  height: 60%;
  margin: 2% auto 0;
  border-radius: 10px;
}
.timestamp {
  height: 10%;
  text-align: center;
}
.desc {
  height: 90%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 3em;
}
.btns {
  display: flex;
  justify-content: center;
  margin-top: 3%;
}
.btns button {
  width: 8%;
  height: 2em;
  margin: 0 1em;
  font-size: 1.1em;
}
</style>
