<template>
  <h1>?</h1>
</template>
<script>
//import http from '@/util/http-common';
export default {
  name: 'NoticeDesc',

  //   created() {
  //     http
  //       .get(`/admin/board/detail/${this.$route.query.no}`)
  //       .then(({ data }) => {
  //         console.log(data);
  //         if (data === 'SUCCESS') {
  //           alert('성공');
  //         }
  //       })
  //       .catch(() => {
  //         alert('실패');
  //       });
  //   },
};
console.log(this.$route.query.no);
</script>
