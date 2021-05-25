<!-- 뉴스 크롤링 -->
<template>
  <div class="news_wrap">
    <h1 class="title">News</h1>
    <div>
      <news-item v-for="(n, idx) in news" :key="idx" :n="n" />
    </div>
  </div>
</template>
<script>
import NewsItem from '@/components/items/newsItem.vue';

import { mapGetters } from 'vuex';
export default {
  name: 'NewsComp',
  components: { NewsItem },

  computed: {
    ...mapGetters(['news']),
  },
  created() {
    this.$store.dispatch('getNews');
  },
};
</script>
<style scoped>
.news_wrap {
  width: 90%;
  margin: 0 auto 10%;
  font-size: 1.5em;
  text-align: center;
  background-color: #d3d3d3;
  border-radius: 10px;
  padding: 1em 0;
}
.title {
  margin: 0 0 0.5em;
}
</style>
