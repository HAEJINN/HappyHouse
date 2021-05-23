<template>
  <div>
    <span>{{ post.id }}</span>
    <router-link :to="`/postDetail?id=${post.id}`">{{ post.title }}</router-link>
    <span>{{ post.userid }}</span>
    <span>{{ post.content }}</span>
    <span>{{ post.timestamp }}</span>
  </div>
</template>

<script>
export default {
  name: 'row',
  props: ['post'],
};
</script>
