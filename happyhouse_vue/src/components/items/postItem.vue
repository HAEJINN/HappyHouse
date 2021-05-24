<template>
  <div class="post_item">
    <div>{{ post.id }}</div>
    <div>
      <router-link :to="`/postDetail?id=${post.id}`">{{ post.title }}</router-link>
    </div>
    <div>{{ post.userid }}</div>
    <div>{{ post.content }}</div>
    <div>{{ post.timestamp }}</div>
  </div>
</template>

<script>
export default {
  name: 'row',
  props: ['post'],
};
</script>
<style scoped>
.post_item {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
}
.post_item div {
  margin: 0 0.5em;
}
</style>
