<template>
  <div id="googlemap">
    <div v-if="type == 'favorite'" class="favo">
      <input type="checkbox" v-model="cctvVisible" />cctv
      <input type="checkbox" v-model="convenVisible" /> 편의점
      <input type="checkbox" v-model="cafeVisible" />카페
      <input type="checkbox" v-model="pharVisible" /> 약국
      <input type="checkbox" v-model="busVisible" />버스정류장
      <input type="checkbox" v-model="trainVisible" /> 지하철역
      <button @click="pinclear()">clear</button>
    </div>
    <GmapMap
      ref="mapRef"
      :center="center"
      :zoom="zoom"
      :class="{ googlemapsize: type != 'favorite', favoritemapsize: type == 'favorite' }"
    >
      <GmapMarker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="markerclick(m)"
        :icon="{ url: require('@/assets/marker.png') }"
      />
      <GmapMarker
        :key="'cctv' + index"
        v-for="(m, index) in cctvmarkers"
        :position="m.position"
        :icon="{ url: require('@/assets/cctv.png') }"
        :visible="cctvVisible"
      />
      <GmapMarker
        :key="'conven' + index"
        v-for="(m, index) in convenmarkers"
        :position="m.position"
        :icon="{ url: require('@/assets/store.png') }"
        :visible="convenVisible"
      />
      <GmapMarker
        :key="'cafe' + index"
        v-for="(m, index) in cafemarkers"
        :position="m.position"
        :icon="{ url: require('@/assets/cafeee.png') }"
        :visible="cafeVisible"
      />
      <GmapMarker
        :key="'phar' + index"
        v-for="(m, index) in pharmarkers"
        :position="m.position"
        :icon="{ url: require('@/assets/pill.png') }"
        :visible="pharVisible"
      />
      <GmapMarker
        :key="'bus' + index"
        v-for="(m, index) in busmarkers"
        :position="m.position"
        :icon="{ url: require('@/assets/buss.png') }"
        :visible="busVisible"
      />
      <GmapMarker
        :key="'train' + index"
        v-for="(m, index) in trainmarkers"
        :position="m.position"
        :icon="{ url: require('@/assets/train.png') }"
        :visible="trainVisible"
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
import take from 'lodash/take';
import http from '@/util/http-common';
import { mapGetters } from 'vuex';

export default {
  name: 'GoogleMap',
  props: ['type'],
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
      cafemarkers: [],
      pharmarkers: [],
      busmarkers: [],
      trainmarkers: [],
      cctvVisible: false,
      convenVisible: false,
      cafeVisible: false,
      pharVisible: false,
      busVisible: false,
      trainVisible: false,
      infoWinOpen: false,
      infovalue: {
        no: '',
        content: '',
        position: this.center,
      },
    };
  },
  computed: {
    ...mapGetters(['userInfo']),
    data() {
      return this.$store.state.results;
    },
    cctvs() {
      return this.$store.state.cctvs;
    },
    convens() {
      return this.$store.state.convens;
    },
    cafes() {
      return this.$store.state.cafes;
    },
    phars() {
      return this.$store.state.phars;
    },
    buss() {
      return this.$store.state.buss;
    },
    trains() {
      return this.$store.state.trains;
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
    cafes() {
      if (this.cafes.length > 0) {
        take(this.cafes, this.cafes.length).map(({ lat, lng }) => {
          var mar = {
            position: {
              lat: parseFloat(lat),
              lng: parseFloat(lng),
            },
          };
          this.cafemarkers.push(mar);
        });
      }
    },
    phars() {
      if (this.phars.length > 0) {
        take(this.phars, this.phars.length).map(({ lat, lng }) => {
          var mar = {
            position: {
              lat: parseFloat(lat),
              lng: parseFloat(lng),
            },
          };
          this.pharmarkers.push(mar);
        });
      }
    },
    buss() {
      if (this.buss.length > 0) {
        take(this.buss, this.buss.length).map(({ lat, lng }) => {
          var mar = {
            position: {
              lat: parseFloat(lat),
              lng: parseFloat(lng),
            },
          };
          this.busmarkers.push(mar);
        });
      }
    },
    trains() {
      if (this.trains.length > 0) {
        take(this.trains, this.trains.length).map(({ lat, lng }) => {
          var mar = {
            position: {
              lat: parseFloat(lat),
              lng: parseFloat(lng),
            },
          };
          this.trainmarkers.push(mar);
        });
      }
    },
  },
  methods: {
    markerclick(item) {
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
      if (this.userInfo.userid != 'admin') {
        if (content.houseno != undefined && confirm('즐겨찾기에 추가할까요?')) {
          http
            .post('/user/favorite', content.houseno, {
              headers: {
                'access-token': window.localStorage.getItem('access-token'),
              },
            })
            .then(() => {
              alert('즐겨찾기 등록 성공');
            })
            .catch(() => {
              alert('등록에 실패했습니다.');
            });
        }
      }
    },
    clearMarkers() {
      this.markers = [];
      this.cctvmarkers = [];
      this.convenmarkers = [];
      this.cafemarkers = [];
      this.pharmarkers = [];
      this.busmarkers = [];
      this.trainmarkers = [];
    },
    setCenter(position) {
      this.center = position;
      this.zoom = 18;
    },
    pinclear() {
      this.cctvVisible = false;
      this.convenVisible = false;
      this.cafeVisible = false;
      this.pharVisible = false;
      this.busVisible = false;
      this.trainVisible = false;
    },
  },
};
</script>
<style scoped>
.favo {
  display: flex;
  justify-content: center;
  margin: 30px 0;
}
.favo input {
  margin: 0 5px;
}
.favo button {
  margin: 0 5px;
}
</style>

<style>
.googlemapsize {
  width: 33vw;
  height: 55vh;
}
.googlemapsize .vue-map-container {
  width: 50%;
  height: 50%;
}

.favoritemapsize {
  width: 70vw;
  height: 70vh;
}
.favoritemapsize .vue-map-container {
  width: 100%;
  height: 100%;
}
</style>
