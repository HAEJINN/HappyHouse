<template>
  <div class="back">
    <update-form type="update" />
  </div>
</template>

<script>
import UpdateForm from '@/components/form.vue';
export default {
  name: 'update',
  components: {
    UpdateForm,
  },
};
</script>
<style scoped>
.back {
  position: relative;
}
.back::before {
  display: block;
  position: absolute;
  content: '';
  width: 100%;
  height: 100vh;
  background-image: url('../../assets/bg.jpg');
  z-index: -1;
  opacity: 0.8;
}
</style>
