<template lang="">
  <div>
    <pie-chart></pie-chart>
    <line-chart></line-chart>
    <h1>이번달 방문자 {{ statics.monthvisituser }}</h1>
  </div>
</template>
<script>
import { mapGetters } from 'vuex';
import PieChart from '@/components/items/piechart.vue';
import LineChart from '@/components/items/linechart.vue';

export default {
  name: 'dashboard',
  components: {
    PieChart,
    LineChart,
  },
  computed: {
    ...mapGetters(['statics']),
  },
  created() {
    this.$store.dispatch('loadstatics');
  },
};
</script>
<style lang=""></style>
