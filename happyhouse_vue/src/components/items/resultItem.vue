<template>
  <div>
    <span>{{ result.aptname }}</span>
    <span>{{ result.buildyear }}</span>
    <span>{{ result.area }}</span>
    <span>{{ result.jibun }}</span>
    <span>{{ result.dealamount }}</span>
  </div>
</template>

<script>
export default {
  name: "row",
  props: ["result"],
  created() {
    console.log(this.result);
  },
};
</script>
