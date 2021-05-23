<template>
  <div>
    <h1>RankApt</h1>
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
