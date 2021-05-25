<template>
  <div>
    <h1>즐겨찾기 매물 비교</h1>
    <favorite-list v-for="(favorite, idx) in flist" :key="idx" :favorite="favorite" />
    <google-map />
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
      console.log(this.flist);
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
