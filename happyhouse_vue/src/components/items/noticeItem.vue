<template>
  <tr>
    <td>{{ notice.no }}</td>
    <td>
      <router-link :to="`/noticeDetail?no=${notice.no}`">{{ notice.title }}</router-link>
    </td>
    <td>{{ notice.userid }}</td>
    <td>{{ notice.timestamp }}</td>
    <td>{{ notice.content }}</td>
  </tr>
</template>

<script>
export default {
  name: 'row',
  props: ['notice'],
};
</script>
<style scoped></style>
