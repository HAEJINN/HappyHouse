<template>
  <div id="googlemap">
    <button @click="clearMarkers">clear</button>
    <GmapMap ref="mapRef" :center="center" :zoom="zoom" style="width: 70vw; height: 70vh">
      <GmapMarker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="markerclick(m)"
      />
      <!-- :icon="{url: require('@/assets/LogoMakr-4pVzaR.png'),}" -->
      <GmapMarker :key="'cctv' + index" v-for="(m, index) in cctvmarkers" :position="m.position" />
      <GmapMarker
        :key="'conven' + index"
        v-for="(m, index) in convenmarkers"
        :position="m.position"
      />
      <GmapInfoWindow
        :position="infovalue.position"
        :opened="infoWinOpen"
        @closeclick="infoWinOpen = false"
      >
        <div v-html="infovalue.content" @click="infoclick(infovalue)"></div>
      </GmapInfoWindow>
    </GmapMap>
  </div>
</template>

<script>
import take from "lodash/take";
import http from "@/util/http-common";

export default {
  name: "GoogleMap",
  data() {
    return {
      center: {
        lat: 37.500131499999995,
        lng: 127.03242579999998,
      },
      zoom: 15,
      markers: [],
      cctvmarkers: [],
      convenmarkers: [],
      infoWinOpen: false,
      infovalue: {
        no: "",
        content: "",
        position: this.center,
      },
    };
  },
  computed: {
    data() {
      return this.$store.state.results;
    },
    cctvs() {
      return this.$store.state.cctvs;
    },
    convens() {
      return this.$store.state.convens;
    },
  },
  watch: {
    data() {
      // 집 마커 추가
      this.clearMarkers();
      if (this.data.length > 0) {
        this.setCenter({
          lat: parseFloat(this.data[0].lat),
          lng: parseFloat(this.data[0].lng),
        });
        take(this.data, this.data.length).map(({ no, aptname, lat, lng }) => {
          var mar = {
            houseno: no,
            position: {
              lat: parseFloat(lat),
              lng: parseFloat(lng),
            },
            aptname: aptname,
          };
          this.markers.push(mar);
        });
      }
    },
    cctvs() {
      //cctv 마커 추가
      if (this.cctvs.length > 0) {
        take(this.cctvs, this.cctvs.length).map(({ lat, lng }) => {
          var mar = {
            position: {
              lat: parseFloat(lat),
              lng: parseFloat(lng),
            },
          };
          this.cctvmarkers.push(mar);
        });
      }
    },
    convens() {
      if (this.convens.length > 0) {
        take(this.convens, this.convens.length).map(({ lat, lng }) => {
          var mar = {
            position: {
              lat: parseFloat(lat),
              lng: parseFloat(lng),
            },
          };
          this.convenmarkers.push(mar);
        });
      }
    },
  },
  methods: {
    markerclick(item) {
      console.log("markerclick");
      this.infovalue = {
        houseno: item.houseno,
        content: item.aptname,
        position: {
          lat: item.position.lat,
          lng: item.position.lng,
        },
      };
      this.setCenter(this.infovalue.position);
      this.infoWinOpen = true;
    },
    infoclick(content) {
      if (content.houseno != undefined && confirm("즐겨찾기에 추가할까요?")) {
        http
          .post("/user/favorite", content.houseno, {
            headers: {
              "access-token": window.localStorage.getItem("access-token"),
            },
          })
          .then(() => {
            alert("즐겨찾기 등록 성공");
          })
          .catch(() => {
            alert("등록에 실패했습니다.");
          });
      }
    },
    clearMarkers() {
      this.markers = [];
      this.cctvmarkers = [];
      this.convenmarkers = [];
    },
    setCenter(position) {
      this.center = position;
      this.zoom = 18;
    },
  },
};
</script>
