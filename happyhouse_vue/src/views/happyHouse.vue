<!-- 로그인 후 제일 첫 화면 -->
<template>
  <div class="main_wrap">
    <navi-comp></navi-comp>
    <div class="main_content">
      <router-view />
    </div>
    <foot-comp></foot-comp>
  </div>
</template>

<script>
import NaviComp from '@/components/navi.vue';
import FootComp from '@/components/foot.vue';
export default {
  name: 'happyhouse',
  components: {
    NaviComp,
    FootComp,
  },
};
</script>
<style scoped>
.main_wrap {
  height: 100%;
  width: 100%;
  background-color: lavender;
}
.main_content {
  display: flex;
  justify-content: center;
  background-color: #ffffff;
  width: 80%;
  margin: 0 auto;
}
</style>
