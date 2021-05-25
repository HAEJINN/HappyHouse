<!-- 메인 중단 컨텐츠 -->
<template>
  <div>
    <div class="space"><span>HAPPY HOUSE</span></div>
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
<style scoped>
.space {
  display: flex;
  justify-content: center;
  align-items: flex-end;
  width: 80%;
  height: 100px;
  margin: 0 auto;
  border-bottom: 1px solid black;
}
.space span {
  display: block;
  font-size: 3em;
}
</style>
