<template>
  <div class="notice_item">
    <div>{{ notice.id }}</div>
    <div>
      <router-link :to="`/noticeDetail?id=${notice.id}`">{{ notice.title }}</router-link>
    </div>
    <div>{{ notice.userid }}</div>
    <div>{{ notice.content }}</div>
    <div>{{ notice.timestamp }}</div>
  </div>
</template>

<script>
export default {
  name: 'row',
  props: ['notice'],
};
</script>
<style scoped>
.notice_item {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
}
.notice_item div {
  margin: 0 0.5em;
}
</style>
