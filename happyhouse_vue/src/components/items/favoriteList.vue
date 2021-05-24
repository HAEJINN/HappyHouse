<template lang="">
  <div>
    <h1>list</h1>
    <h3 @click="setfavorite(favorite.lat, favorite.lng)">
      {{ favorite.aptname }}
    </h3>
    <h3>{{ favorite.dealamount }}</h3>
    <h3>{{ favorite.lat }}</h3>
    <h3>{{ favorite.lng }}</h3>
  </div>
</template>
<script>
import http from "@/util/http-common";

export default {
  name: "favoriterow",
  props: ["favorite"],
  methods: {
    setfavorite(lat, lng) {
      this.getcctv(lat, lng);
      this.getconven(lat, lng);
      //this.getcctv(lat, lng);, seter apt pos
    },
    getcctv(lat, lng) {
      http
        .post("/pos/cctv", {
          lat: lat,
          lng: lng,
        })
        .then(({ data }) => {
          console.log(data);
        })
        .catch(() => {
          alert("get cctv list error");
        });
    },

    getconven(lat, lng) {
      http
        .post("/pos/conven", {
          lat: lat,
          lng: lng,
        })
        .then(({ data }) => {
          console.log(data);
        })
        .catch(() => {
          alert("get conven list error");
        });
    },
  },
};
</script>
<style lang=""></style>
