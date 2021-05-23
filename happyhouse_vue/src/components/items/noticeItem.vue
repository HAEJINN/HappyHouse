<template>
  <div>
    <span>{{ notice.id }}</span>
    <router-link :to="`/noticeDetail?id=${notice.id}`">{{ notice.title }}</router-link>
    <span>{{ notice.userid }}</span>
    <span>{{ notice.content }}</span>
    <span>{{ notice.timestamp }}</span>
  </div>
</template>

<script>
export default {
  name: 'row',
  props: ['notice'],
};
</script>
