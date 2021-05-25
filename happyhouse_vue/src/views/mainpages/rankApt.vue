<template>
  <div>
    <h1 class="main_title">최근 실 거래가 상위 아파트</h1>
    <rank-item v-for="(rank, idx) in ranks" :key="idx" :rank="rank" />
    <div class="space"></div>
  </div>
</template>
<script>
import RankItem from '@/components/items/aptItem.vue';
import { mapGetters } from 'vuex';
export default {
  name: 'RankComp',
  components: { RankItem },

  computed: {
    ...mapGetters(['ranks']),
  },
  created() {
    this.$store.dispatch('getRanks');
  },
};
</script>
<style scoped>
.main_wrap {
  width: 100%;
  padding: 1em 0 2em;
  margin: 50px 0;
  font-size: 1.3em;
  /* background-color: blanchedalmond; */
}
.main_title {
  text-align: center;
}
</style>
