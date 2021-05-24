<!-- 공지사항 전체 목록 -->
<template>
  <div>
    <h1>공지사항</h1>
    <table>
      <thead>
        <tr>
          <th>글번호</th>
          <th>글제목</th>
          <th>작성자</th>
          <th>작성시간</th>
          <th>내용</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(notice, idx) in notices" :key="idx">
          <td>{{ notice.no }}</td>
          <td>
            <router-link :to="`noticeDesc?no=${notice.no}`">{{ notice.title }}</router-link>
          </td>
          <td>{{ notice.userid }}</td>
          <td>{{ notice.timestamp }}</td>
          <td>{{ notice.content }}</td>
        </tr>
      </tbody>
    </table>
    <notice-desc />
  </div>
</template>
<script>
import { mapGetters } from 'vuex';
import NoticeDesc from '@/components/noticeDesc.vue';
export default {
  name: 'NoticeDetail',
  components: {
    NoticeDesc,
  },

  computed: {
    ...mapGetters(['notices']),
  },
  created() {
    this.$store.dispatch('getNotices');
  },
};
</script>
