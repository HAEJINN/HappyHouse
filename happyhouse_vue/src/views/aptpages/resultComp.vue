<template>
  <div>
    <h1>resultComp</h1>
    <result-item
      v-for="(result, idx) in results"
      :key="idx"
      :result="result"
    ></result-item>
  </div>
</template>
<script>
import ResultItem from "@/components/items/resultItem.vue";
export default {
  name: "ResultComp",
  components: { ResultItem },
  computed: {
    results() {
      return this.$store.state.results;
    },
  },
};
</script>
