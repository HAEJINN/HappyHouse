<template>
  <div @click="mvnews" class="news_item">{{ n.title }}</div>
</template>

<script>
export default {
  name: 'row',
  props: ['n'],
  methods: {
    mvnews() {
      // window.location.href = this.n.url;
      window.open(this.n.url);
    },
  },
};
</script>
<style scoped>
.news_item {
  margin: 12px 0;
  letter-spacing: 0.1em;
}
.news_item:hover {
  cursor: pointer;
  text-decoration: underline;
}
</style>
