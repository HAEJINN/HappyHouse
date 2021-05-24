<template>
  <div class="main_wrap">
    <regist-form></regist-form>
  </div>
</template>
<script>
import RegistForm from '@/components/form.vue';
export default {
  name: 'regist',
  components: {
    RegistForm,
  },
};
</script>
<style scoped>
.main_wrap {
  height: 100vh;
}
.main_wrap::after {
  display: block;
  position: absolute;
  content: '';
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  background-image: url('../../../src/assets/main_house.jpg');
  background-size: cover;
  opacity: 0.7;
  z-index: -10;
}
</style>
