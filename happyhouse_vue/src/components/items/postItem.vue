<template>
  <tr class="tr">
    <td class="td1">{{ post.no }}</td>
    <td class="td1">
      <router-link :to="`postDesc?no=${post.no}`" class="mvlink">{{ post.title }}</router-link>
    </td>
    <td class="td1">{{ post.userid }}</td>
    <td class="td2">{{ post.timestamp }}</td>
  </tr>
</template>

<script>
export default {
  name: 'row',
  props: ['post'],
};
</script>
<style scoped>
.tr {
  font-size: 0.8em;
  text-align: center;
}
.td1 {
  width: 20%;
}
.td2 {
  width: 40%;
}
.mvlink {
  text-decoration: none;
  color: blue;
}
.mvlink:hover {
  font-size: 110%;
}
</style>
