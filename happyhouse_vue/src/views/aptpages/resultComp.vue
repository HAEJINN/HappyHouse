<template>
  <div class="wrap">
    <google-map />
    <div class="results">
      <div class="title">
        <span>이름 | </span>
        <span> 준공년도 | </span>
        <span> 면적 | </span>
        <span> 지번 | </span>
        <span> 거래가</span>
      </div>
      <result-item v-for="(result, idx) in results" :key="idx" :result="result"></result-item>
    </div>
  </div>
</template>
<script>
import GoogleMap from "@/components/items/googlemap.vue";
import ResultItem from "@/components/items/resultItem.vue";
export default {
  name: "ResultComp",
  components: { GoogleMap, ResultItem },
  computed: {
    results() {
      return this.$store.state.results;
    },
  },
};
</script>
<style scoped>
.wrap {
  text-align: center;
  width: 100%;
  display: flex;
}
.results {
  width: 60%;
  margin: 5em auto;
  max-height: 35vh;
  overflow: auto;
}
.title {
  width: 100%;
  font-size: 1.5em;
  margin-bottom: 1em;
}
</style>
