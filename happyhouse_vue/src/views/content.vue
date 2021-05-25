<!-- 메인 중단 컨텐츠 -->
<template>
  <div class="wrap">
    <div class="space"><span>HAPPY HOUSE</span></div>
    <rank-apt></rank-apt>
    <div class="space2"></div>
    <board-comp></board-comp>
    <div class="space3"></div>
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
.wrap {
  width: 100%;
}
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
.space2 {
  width: 95%;
  height: 30px;
  margin: 0 auto;
  border-top: 1px solid black;
}
.space3 {
  width: 95%;
  height: 30px;
  margin: 30px auto 0;
  border-top: 1px solid black;
}
</style>
