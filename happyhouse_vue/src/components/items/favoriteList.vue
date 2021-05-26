<template lang="">
  <div class="wrap">
    <div class="item">
      <h3 @click="setfavorite()">
        {{ favorite.aptname }}
      </h3>
      <!-- <h3>{{ favorite.dealamount }}</h3>
      <h3>{{ favorite.lat }}</h3>
      <h3>{{ favorite.lng }}</h3> -->
    </div>
    <button @click="deletefavorite()" class="deletebtn">관심지역 삭제</button>
  </div>
</template>
<script>
export default {
  name: 'favoriterow',
  props: ['favorite'],
  methods: {
    setfavorite() {
      this.$store.dispatch('clearMapData');
      this.$store.dispatch('loadCctvs', this.favorite);
      this.$store.dispatch('loadConvens', this.favorite);
      this.$store.dispatch('loadCafes', this.favorite);
      this.$store.dispatch('loadPhars', this.favorite);
      this.$store.dispatch('loadBuss', this.favorite);
      this.$store.dispatch('loadTrains', this.favorite);
      this.$store.dispatch('setSingleApt', this.favorite);
    },
    deletefavorite() {
      this.$store.dispatch('deletefavorite', this.favorite.no);
    },
  },
};
</script>
<style scoped>
.wrap {
  display: flex;
  justify-content: center;
  align-items: center;
}
.item {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 1.1em;
  letter-spacing: 0.2em;
}
h3 {
  margin: 0.5em 0;
}
.deletebtn {
  margin: 0 20px;
}
</style>
