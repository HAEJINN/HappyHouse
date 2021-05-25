<template lang="">
  <div>
    <div class="space"><span>Static DashBoard</span></div>

    <div class="blockclass">
      <pie-chart></pie-chart>
      <div class="text"><span>남자, 여자 숫자</span></div>
    </div>
    <div class="blockclass">
      <line-chart></line-chart>
      <div class="text">
        <span>이번달 방문자 {{ statics.monthvisituser }}</span>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
import PieChart from "@/components/items/piechart.vue";
import LineChart from "@/components/items/linechart.vue";

export default {
  name: "dashboard",
  components: {
    PieChart,
    LineChart,
  },
  computed: {
    ...mapGetters(["statics"]),
  },
  created() {
    this.$store.dispatch("loadstatics");
  },
};
</script>
<style scoped>
pie-chart,
line-chart {
  width: 50%;
}
.text {
  width: 50%;
}

.blockclass {
  display: flex;
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
</style>
