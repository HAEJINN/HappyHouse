<!-- 로그인 후 제일 첫 화면 -->
<template>
  <div>
    <navi-comp></navi-comp>
    <router-view />
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
