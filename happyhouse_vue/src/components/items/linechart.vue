<template lang="">
  <div>
    <div id="lineChart" style="fill: #000"></div>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
import bb, { line } from "billboard.js";
import "billboard.js/dist/billboard.css";

export default {
  name: "lineChart1",
  data() {
    return {
      chart: null,
      column1: [],
      column2: [],
    };
  },
  computed: {
    ...mapGetters(["statics"]),
  },
  watch: {
    statics() {
      var i = 0;
      console.log(this.statics.weekvisiterlist);
      if (this.chart == null) {
        this.column1 = ["x"];
        this.column2 = ["방문자 수"];
        for (i = 0; i < this.statics.weekvisiterlist.length; i++) {
          this.column1.push(this.statics.weekvisiterlist[i].time);
          this.column2.push(this.statics.weekvisiterlist[i].cnt);
        }

        this.chart = bb.generate({
          type: line(),
          data: {
            x: "x",
            columns: [this.column1, this.column2],
            colors: {
              "방문자 수": "black",
            },
          },
          axis: {
            x: {
              type: "timeseries",
              tick: {
                format: "%m-%d",
              },
            },
          },
          bindto: "#lineChart",
        });
      } else {
        this.column1 = ["x"];
        this.column2 = ["방문자 수"];
        for (i = 0; i < this.statics.weekvisiterlist.length; i++) {
          this.column1.push(this.statics.weekvisiterlist[i].time);
          this.column2.push(this.statics.weekvisiterlist[i].cnt);
        }

        this.chart.load({
          columns: [this.column1, this.column2],
        });
      }
    },
  },
};
</script>

<style lang=""></style>
