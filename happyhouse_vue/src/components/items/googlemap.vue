<template>
  <div id="app">
    <button @click="addMarkers">add</button>
    <button @click="clearMarkers">clear</button>
    <button @click="setCenter">move center</button>
    <GmapMap ref="mapRef" :center="center" :zoom="16" style="width: 100vw; height: 100vh">
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
import shuffle from "lodash/shuffle";
import take from "lodash/take";
const sample = [
  { lat: 37.5047592, lng: 127.0415586, price: "₩52" },
  { lat: 37.5082055, lng: 127.0363408, price: "₩66" },
  { lat: 37.5055726, lng: 127.0294372, price: "₩40" },
  { lat: 37.4994, lng: 127.03545, price: "₩39" },
  { lat: 37.4916279, lng: 127.0289673, price: "₩43" },
  { lat: 37.49479, lng: 127.03665, price: "₩54" },
  { lat: 37.5052889, lng: 127.0258825, price: "₩50" },
  { lat: 37.503028, lng: 127.0237718, price: "₩47" },
  { lat: 37.506151, lng: 127.028389, price: "₩50" },
  { lat: 37.505394, lng: 127.028807, price: "₩16" },
  { lat: 37.4918215, lng: 127.0299, price: "₩38" },
  { lat: 37.504824, lng: 127.028217, price: "₩195" },
  { lat: 37.5012203, lng: 127.035459, price: "₩55" },
  { lat: 37.49869, lng: 127.0323734, price: "₩51" },
  { lat: 37.5028748, lng: 127.0394336, price: "₩32" },
  { lat: 37.5065218, lng: 127.0303014, price: "₩41" },
  { lat: 37.4935486, lng: 127.0280787, price: "₩49" },
  { lat: 37.4995308, lng: 127.0354614, price: "₩28" },
  { lat: 37.50664, lng: 127.03158, price: "₩64" },
  { lat: 37.5024767, lng: 127.0399139, price: "₩49" },
  { lat: 37.5013577, lng: 127.0357776, price: "₩40" },
];
export default {
  name: "App",
  data() {
    return {
      center: {
        lat: 37.500131499999995,
        lng: 127.03242579999998,
      },
      data: sample,
      markers: [],
      infovalue: {
        content: "",
        position: this.center,
      },
    };
  },
  computed: {},
  watch: {},
  methods: {
    // 마커 추가
    addMarkers() {
      take(shuffle(this.data), 20).map(({ price, lat, lng }, i) => {
        var mar = {
          position: {
            lat: lat,
            lng: lng,
          },
          price: price + i * 100,
        };
        this.markers.push(mar);
      });
    },
    markerclick(item) {
      console.log("markerclick");
      this.infovalue.content = item.price; // content
      let position = {
        lat: item.position.lat * 1 + 0.0005,
        lng: item.position.lng * 1,
      };
      this.setCenter(position);
      this.infovalue.position = position;
      this.infoWinOpen = true;
      console.log(this.infoWinOpen);
    },
    clearMarkers() {
      this.markers = [];
    },
    setCenter(position) {
      this.center = position;
    },
  },
};
</script>
