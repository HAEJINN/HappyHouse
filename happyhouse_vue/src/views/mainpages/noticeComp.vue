<template>
  <div class="notice_wrap">
    <h1 class="notice_title">공지사항</h1>
    <div class="btn_div">
      <router-link to="noticeDetail" class="detail_link">더보기</router-link>
    </div>
    <table class="table">
      <thead>
        <tr>
          <th class="th1">글번호</th>
          <th class="th2">글제목</th>
          <th class="th1">작성자</th>
          <!-- <th class="th2">작성시간</th> -->
        </tr>
      </thead>
      <tbody>
        <notice-item
          v-for="(notice, idx) in notices"
          :key="idx"
          :notice="notice"
        />
      </tbody>
    </table>
  </div>
</template>
<script>
import NoticeItem from "@/components/items/noticeItem.vue";

import { mapGetters } from "vuex";
export default {
  name: "NoticeComp",
  components: { NoticeItem },

  computed: {
    ...mapGetters(["notices"]),
  },
  created() {
    this.$store.dispatch("getNotices");
  },
};
</script>
<style scoped>
.notice_wrap {
  /* background-color: blanchedalmond; */
  margin-bottom: 50px;
  width: calc(50% - 0.5px);
}
.notice_title {
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
  table-layout: fixed;
}
.th1 {
  width: 20%;
}
.th2 {
  width: 60%;
}
</style>
