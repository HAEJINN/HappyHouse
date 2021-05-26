<template>
  <div class="board_wrap">
    <notice-comp></notice-comp>
    <div class="space"></div>
    <post-comp></post-comp>
  </div>
</template>

<script>
import NoticeComp from "@/views/mainpages/noticeComp.vue";
import PostComp from "@/views/mainpages/postComp.vue";
export default {
  name: "boardComp",
  components: {
    NoticeComp,
    PostComp,
  },
};
</script>
<style scoped>
.board_wrap {
  display: flex;
  flex-direction: row;
  justify-content: center;
  width: 95%;
  margin: 0 auto;
  font-size: 1.5em;
  height: 25%;
}
.space {
  width: 1px;
  margin: 0 20px;
  height: 100%;
  background-color: black;
}
</style>
