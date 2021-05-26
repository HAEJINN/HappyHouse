<template>
  <div v-if="post" class="wrap">
    <div class="title_wrap">
      <h1 class="title">{{ post.title }}</h1>
    </div>
    <div class="writer">
      <p>{{ post.userid }}</p>
    </div>
    <div class="contentwrap">
      <div class="timestamp">
        <p>{{ post.timestamp }}</p>
      </div>
      <div class="desc">
        <p>{{ post.content }}</p>
      </div>
    </div>
    <did class="btns">
      <button v-if="userInfo.userid == post.userid" @click="modify">
        수정
      </button>
      <button v-if="userInfo.userid == post.userid" @click="deleteP">
        삭제
      </button>
      <button @click="mvlist">목록</button>
    </did>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
export default {
  name: "PostDesc",
  computed: {
    ...mapGetters(["userInfo", "post"]),
  },
  created() {
    this.$store.dispatch("searchP", this.$route.query.no);
  },
  methods: {
    modify() {
      this.$router.push("/happyhouse/updatePost");
    },
    deleteP() {
      this.$store.dispatch("deleteP", this.$route.query.no);
      this.$router.push("/happyhouse/postDetail");
    },
    mvlist() {
      this.$router.push("/happyhouse/postDetail");
    },
  },
};
</script>
<style scoped>
.wrap {
  width: 100%;
  height: 100vh;
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
  font-size: 1.5em;
  margin: 0 2em;
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
