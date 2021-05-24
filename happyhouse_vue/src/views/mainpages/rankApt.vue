<template>
  <div class="main_wrap">
    <h1>Ranking</h1>
    <rank-item v-for="(rank, idx) in ranks" :key="idx" :rank="rank" />
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
  padding: 3em;
  border: 1px solid black;
  font-size: 1.5em;
  text-align: center;
}
</style>
