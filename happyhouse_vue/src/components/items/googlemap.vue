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
      <GmapInfoWindow
        :position="infovalue.position"
        :opened="infoWinOpen"
        @closeclick="infoWinOpen = false"
      >
        <div v-html="infovalue.content"></div>
      </GmapInfoWindow>
    </GmapMap>
  </div>
</template>

<script>
import take from "lodash/take";

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
      infovalue: {
        content: "",
        position: this.center,
      },
    };
  },
  computed: {
    data() {
      return this.$store.state.results;
    },
  },
  watch: {
    data() {
      // 마커 추가
      if (this.data.length > 0) {
        this.clearMarkers();
        this.setCenter({
          lat: parseFloat(this.data[0].lat),
          lng: parseFloat(this.data[0].lng),
        });
        take(this.data, this.data.length).map(({ aptname, lat, lng }) => {
          var mar = {
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
  },
  methods: {
    markerclick(item) {
      console.log("markerclick");
      this.infovalue.content = item.aptname;
      let position = {
        lat: item.position.lat,
        lng: item.position.lng,
      };
      this.setCenter(position);
      this.infovalue.position = position;
      this.infoWinOpen = true;
    },
    clearMarkers() {
      this.markers = [];
    },
    setCenter(position) {
      this.center = position;
      this.zoom = 18;
    },
  },
};
</script>
