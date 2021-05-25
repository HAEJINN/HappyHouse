<template>
  <div>
    <div class="main_wrap">
      <div class="main_item">
        <h1 class="main_title">최근 실 거래가 상위 아파트</h1>
        <rank-item v-for="(rank, idx) in ranks" :key="idx" :rank="rank" />
      </div>
    </div>
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
  width: 90%;
  margin: 50px auto 30px;
  font-size: 1.3em;
  background-color: #d3d3d3;
  border-radius: 10px;
  position: relative;
  padding-bottom: 1em;
}
.main_title {
  padding-top: 1em;
  text-align: center;
}
.main_wrap::before {
  display: block;
  content: '';
  position: absolute;
  width: 100%;
  height: 100%;
  background-image: url('../../assets/money.jpg');
  background-size: cover;
  opacity: 0.1;
}
</style>
