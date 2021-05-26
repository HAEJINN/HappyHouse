<template>
  <div>
    <h1 class="title">즐겨찾기 매물 비교</h1>
    <p>이름을 클릭하고 찾고싶은 주변 시설을 고르세요</p>
    <favorite-list v-for="(favorite, idx) in flist" :key="idx" :favorite="favorite" />
    <google-map type="favorite" />
  </div>
</template>
<script>
import FavoriteList from '@/components/items/favoriteList.vue';
import GoogleMap from '@/components/items/googlemap.vue';

export default {
  name: 'favoriteApt',
  data() {
    return {
      flistlength: 0,
    };
  },
  computed: {
    flist() {
      return this.$store.state.flist;
    },
  },
  watch: {
    flist() {
      if (this.flist.length != this.flistlength) {
        this.flistlength = this.$store.state.flist.length;
        this.$store.dispatch('loadflist');
      }
    },
  },
  components: {
    FavoriteList,
    GoogleMap,
  },
  created() {
    this.$store.dispatch('clearMapData');
    this.$store.dispatch('loadflist');
  },
};
</script>
<style scoped>
.title {
  display: block;
  width: 60%;
  margin: 0 auto;
  text-align: center;
  border-bottom: 1px solid black;
  padding: 2em 0 0.5em;
  margin-bottom: 0.5em;
}
p {
  text-align: center;
  color: #444444;
  font-size: 1.2em;
}
</style>
