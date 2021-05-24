<template>
  <div class="notice_wrap">
    <h1>noticeComp</h1>
    <notice-item v-for="(notice, idx) in notices" :key="idx" :notice="notice" />
    <router-link to="noticeDetail">notice</router-link>
  </div>
</template>
<script>
import NoticeItem from '@/components/items/noticeItem.vue';
import { mapGetters } from 'vuex';
export default {
  name: 'NoticeComp',
  components: { NoticeItem },

  computed: {
    ...mapGetters(['notices']),
  },
  created() {
    this.$store.dispatch('getNotices');
  },
};
</script>
<style scoped>
.notice_wrap {
  width: 50%;
  border: 1px solid black;
  padding: 3em;
  margin: 0 3em;
}
</style>
