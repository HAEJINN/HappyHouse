<template>
  <div class="notice_wrap">
    <h1 class="notice_title">공지사항</h1>
    <router-link to="noticeDetail" class="detail_link">더보기</router-link>
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
        <notice-item v-for="(notice, idx) in notices" :key="idx" :notice="notice" />
      </tbody>
    </table>
  </div>
</template>
<script>
import NoticeItem from '@/components/items/noticeItem.vue';

import { mapGetters } from 'vuex';
export default {
  name: 'NoticeComp',
  components: { NoticeItem },

  computed: {
    ...mapGetters(['notices']),
  },
  created() {
    this.$store.dispatch('getNotices');
  },
};
</script>
<style scoped>
.notice_wrap {
  background-color: blanchedalmond;
  padding: 1em;
  margin-bottom: 50px;
  margin-right: 5px;
}
.notice_title {
  text-align: center;
  font-size: 1.5em;
}
.detail_link {
  position: relative;
  bottom: 0;
  right: 0;
}
</style>
