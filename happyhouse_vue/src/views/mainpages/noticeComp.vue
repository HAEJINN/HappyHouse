<template>
  <div>
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
