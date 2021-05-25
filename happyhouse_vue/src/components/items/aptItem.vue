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
.items_wrap div:first-child {
  width: 20%;
  margin-bottom: 0.5em;
}
.items_wrap div:last-child {
  width: 20%;
  margin-bottom: 0.5em;
  text-align: center;
}
</style>
