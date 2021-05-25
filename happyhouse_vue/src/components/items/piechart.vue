<template lang="">
  <div>
    <div id="pieChart"></div>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
import bb, { pie } from "billboard.js";

export default {
  name: "piechart1",
  data() {
    return {
      chart: null,
      datalist: [
        ["남자", 0],
        ["여자", 0],
      ],
    };
  },
  computed: {
    ...mapGetters(["statics"]),
  },
  watch: {
    statics() {
      if (this.chart == null) {
        this.chart = bb.generate({
          size: {
            height: 480,
            width: 480,
          },
          data: {
            columns: [
              ["남자", this.statics.manusercount],
              ["여자", this.statics.womanusercount],
            ],
            type: pie(),
          },
          color: {
            pattern: ["#1f77b4", "#aec7e8"], // color code
          },
          bindto: "#pieChart",
        });
      } else {
        this.chart.load({
          columns: [
            ["남자", this.statics.manusercount],
            ["여자", this.statics.womanusercount],
          ],
        });
      }
    },
  },
};
</script>

<style lang=""></style>
