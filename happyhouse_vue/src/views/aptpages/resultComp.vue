<template>
  <div>
    <h1>resultComp</h1>
    <google-map />
    <result-item v-for="(result, idx) in results" :key="idx" :result="result"></result-item>
  </div>
</template>
<script>
import GoogleMap from '@/components/items/googlemap.vue';
import ResultItem from '@/components/items/resultItem.vue';
export default {
  name: 'ResultComp',
  components: { GoogleMap, ResultItem },
  computed: {
    results() {
      return this.$store.state.results;
    },
  },
};
</script>
