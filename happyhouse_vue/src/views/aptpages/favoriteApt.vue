<template>
  <div>
    <h1>즐겨찾기 매물 비교</h1>
    <favorite-list />
    <google-map />
  </div>
</template>
<script>
import FavoriteList from '@/components/items/favoriteList.vue';
import GoogleMap from '@/components/items/googlemap.vue';
export default {
  name: 'favoriteApt',
  components: {
    FavoriteList,
    GoogleMap,
  },
};
</script>
