<template>
  <div>
    <h1>즐겨찾기 매물 비교</h1>
    <favorite-list v-for="(favorite, idx) in flist" :key="idx" :favorite="favorite" />
    <google-map />
  </div>
</template>
<script>
import FavoriteList from "@/components/items/favoriteList.vue";
import GoogleMap from "@/components/items/googlemap.vue";
import http from "@/util/http-common";

export default {
  name: "favoriteApt",
  data() {
    return {
      flist: [],
    };
  },
  components: {
    FavoriteList,
    GoogleMap,
  },
  created() {
    http
      .get("/user/favorite", {
        headers: {
          "access-token": window.localStorage.getItem("access-token"),
        },
      })
      .then(({ data }) => {
        this.flist = data;
      })
      .catch(() => {
        alert("????");
      });
  },
};
</script>
