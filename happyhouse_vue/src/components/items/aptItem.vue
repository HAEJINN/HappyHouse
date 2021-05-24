<template>
  <div class="items_wrap">
    <div>{{ rank.aptname }}</div>
    <div>{{ rank.dealamount }}</div>
  </div>
</template>

<script>
export default {
  name: 'row',
  props: ['rank'],
};
</script>
<style scoped>
.items_wrap {
  display: flex;
  justify-content: center;
}
.items_wrap div {
  width: 40%;
}
</style>
