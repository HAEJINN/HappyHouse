<template lang="">
  <div>
    <div class="space"><span class="title">사이트 통계</span></div>

    <div class="blockclass1">
      <pie-chart class="pie"></pie-chart>
      <div class="textmw">
        <div>남자: {{ statics.manusercount }}명</div>
        <div>여자: {{ statics.womanusercount }}명</div>
      </div>
    </div>
    <div class="blockclass2">
      <line-chart></line-chart>
      <div class="textv">
        <span>이번달 방문자 {{ statics.monthvisituser }}</span>
      </div>
    </div>
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
<style scoped>
.blockclass1,
.blockclass2 {
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
}
.space {
  display: flex;
  justify-content: center;
  align-items: flex-end;
  width: 80%;
  height: 100px;
  margin: 0 auto;
  border-bottom: 1px solid black;
}
.pie {
  width: 100%;
}
.textmw {
  position: absolute;
  top: 15%;
  right: 0%;
  font-size: 2em;
}
.textv {
  position: absolute;
  top: 62%;
  right: 5%;
  font-size: 2em;
}
.blockclass1,
.blockclass2 {
  padding: 3em;
}
.title {
  font-size: 2em;
  margin-bottom: 0.5em;
}
</style>
