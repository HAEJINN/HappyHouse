<!-- 뉴스 크롤링 -->
<template>
  <div class="news_wrap">
    <h1>News</h1>
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
  width: 100%;
  padding: 3em;
  font-size: 1.5em;
  text-align: center;
  background-color: blanchedalmond;
  margin-bottom: 50px;
}
</style>
