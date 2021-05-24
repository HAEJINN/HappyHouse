<template>
  <tr>
    <td>{{ post.no }}</td>
    <td>
      <router-link :to="`postDesc?no=${post.no}`">{{ post.title }}</router-link>
    </td>
    <td>{{ post.userid }}</td>
    <td>{{ post.timestamp }}</td>
    <td>{{ post.content }}</td>
  </tr>
</template>

<script>
export default {
  name: 'row',
  props: ['post'],
};
</script>
<style scoped></style>
