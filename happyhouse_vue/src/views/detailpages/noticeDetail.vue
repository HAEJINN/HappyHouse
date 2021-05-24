<!-- 공지사항 전체 목록 -->
<template>
  <div>
    <h1>공지사항</h1>
    <button v-if="userInfo.userid == 'admin'" @click="writePost">글작성</button>
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
  </div>
</template>
<script>
import { mapGetters } from 'vuex';

export default {
  name: 'NoticeDetail',
  computed: {
    ...mapGetters(['userInfo', 'notices']),
  },
  created() {
    this.$store.dispatch('getNotices');
  },
  methods: {
    writePost() {},
  },
};
</script>
