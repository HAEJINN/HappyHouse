<template>
  <tr class="tr">
    <td class="td1">{{ notice.no }}</td>
    <td nowrap class="td2">
      <router-link :to="`noticeDesc?no=${notice.no}`" class="mvlink">{{
        notice.title
      }}</router-link>
    </td>
    <td class="td1">{{ notice.userid }}</td>
    <!-- <td class="td2">{{ notice.timestamp }}</td> -->
  </tr>
</template>

<script>
export default {
  name: "row",
  props: ["notice"],
};
</script>
<style scoped></style>
<style scoped>
.tr {
  font-size: 0.8em;
  text-align: center;
}
.td1 {
  width: 20%;
  text-overflow: ellipsis;
  overflow: hidden;
}
.td2 {
  width: 60%;
  text-overflow: ellipsis;
  overflow: hidden;
}
.mvlink {
  text-decoration: none;
  color: blue;
}
.mvlink:hover {
  font-size: 110%;
}
</style>
