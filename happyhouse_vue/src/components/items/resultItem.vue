<template>
  <div class="wrap">
    <span> {{ result.aptname }}</span>
    <span> {{ result.buildyear }}</span>
    <span> {{ result.area }}</span>
    <!-- <span> {{ result.jibun }} | </span> -->
    <span> {{ result.dealamount }}</span>
  </div>
</template>

<script>
export default {
  name: 'row',
  props: ['result'],
  created() {
    console.log(this.result);
  },
};
</script>
<style scoped>
.wrap {
  width: 100%;
  font-size: 1.2em;
  margin: 0.2em;
}
.wrap span {
  margin: 0 0.2em;
}
</style>
