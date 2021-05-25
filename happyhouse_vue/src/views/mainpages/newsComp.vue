<!-- 뉴스 크롤링 -->
<template>
  <div>
    <div class="news_wrap">
      <h1 class="title">News</h1>
      <div class="click">
        <news-item v-for="(n, idx) in news" :key="idx" :n="n" />
      </div>
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
  /* background-color: #d3d3d3; */
  border-radius: 10px;
  position: relative;
  padding-bottom: 1em;
  z-index: 10;
}
.title {
  margin: 0 0 0.5em;
  padding-top: 1em;
}
.news_wrap::before {
  display: block;
  content: '';
  position: absolute;
  width: 100%;
  height: 100%;
  background-image: url('../../assets/news.jpg');
  background-size: cover;
  opacity: 0.3;
  z-index: -10;
}
/* .click {
  z-index: 2;
} */
</style>
