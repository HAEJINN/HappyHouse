<!-- 로그인 후 제일 첫 화면 -->
<template>
  <div class="main_wrap">
    <navi-comp></navi-comp>
    <!-- <div class="space"></div> -->
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
  position: relative;
  height: 100%;
  width: 100%;
}
.main_wrap::after {
  display: block;
  position: absolute;
  content: '';
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  opacity: 0.85;
  z-index: -1;
  background-image: url('../assets/bg.jpg');
  background-size: cover;
}
.space {
  width: 100%;
  height: 30px;
}
.main_content {
  display: flex;
  justify-content: center;
  background-color: #ffffff;
  width: 70%;
  margin: 10px auto 50px;
  border: none;
  border-radius: 15px;
  overflow: hidden;
}
</style>
