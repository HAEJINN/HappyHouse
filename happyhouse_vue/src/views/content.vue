<!-- 메인 중단 컨텐츠 -->
<template>
  <div>
    <rank-apt></rank-apt>
    <board-comp></board-comp>
    <news-comp></news-comp>
  </div>
</template>

<script>
import RankApt from '@/views/mainpages/rankApt.vue';
import BoardComp from '@/views/mainpages/boardComp.vue';
import NewsComp from '@/views/mainpages/newsComp.vue';
export default {
  name: 'mainpage',
  components: {
    RankApt,
    BoardComp,
    NewsComp,
  },
};
</script>
