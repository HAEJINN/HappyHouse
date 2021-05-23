<!-- 메인 중단 컨텐츠 -->
<template>
  <div>
    <rank-apt></rank-apt>
    <notice-comp></notice-comp>
    <post-comp></post-comp>
    <news-comp></news-comp>
  </div>
</template>

<script>
import RankApt from '@/views/mainpages/rankApt.vue';
import NoticeComp from '@/views/mainpages/noticeComp.vue';
import PostComp from '@/views/mainpages/postComp.vue';
import NewsComp from '@/views/mainpages/newsComp.vue';
export default {
  name: 'mainpage',
  components: {
    RankApt,
    NoticeComp,
    PostComp,
    NewsComp,
  },
};
</script>
