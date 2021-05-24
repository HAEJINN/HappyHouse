<template>
  <div class="board_wrap">
    <notice-comp></notice-comp>
    <post-comp></post-comp>
  </div>
</template>

<script>
import NoticeComp from '@/views/mainpages/noticeComp.vue';
import PostComp from '@/views/mainpages/postComp.vue';
export default {
  name: 'boardComp',
  components: {
    NoticeComp,
    PostComp,
  },
};
</script>
<style scoped>
.board_wrap {
  display: flex;
  font-size: 1.5em;
}
</style>
