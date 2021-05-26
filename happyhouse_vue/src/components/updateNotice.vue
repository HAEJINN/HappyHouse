<template>
  <div class="wrap">
    <update-form type="update" />
  </div>
</template>

<script>
import UpdateForm from '@/components/noticeForm.vue';
export default {
  name: 'update',
  components: {
    UpdateForm,
  },
};
</script>
<style scoped>
.wrap {
  width: 100%;
  height: 80vh;
}
</style>
