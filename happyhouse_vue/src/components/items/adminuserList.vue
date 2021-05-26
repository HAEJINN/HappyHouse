<template lang="">
  <tr>
    <td>{{ user.userid }}</td>
    <td>{{ user.username }}</td>
    <td>{{ user.email }}</td>
    <td>{{ user.phonenumber }}</td>
    <td>{{ user.gender }}</td>
    <td><button @click="deleteuser(user.userid)">유저 삭제</button></td>
  </tr>
  <!-- <button @click="deleteuser(user.userid)">유저 삭제</button> -->
</template>
<script>
import http from '@/util/http-common';

export default {
  name: 'userlist',
  props: ['user'],
  methods: {
    async deleteuser(userid) {
      await http
        .delete(`/admin/user/${userid}`, {
          headers: {
            'access-token': window.localStorage.getItem('access-token'),
          },
        })
        .then(({ data }) => {
          if (data == 'SUCCESS') {
            alert('유저 삭제성공');
          }
        })
        .catch(() => {
          alert('유저 삭제실패');
        });
      this.$router.go();
      //페이지 새로고침
    },
  },
};
</script>
<style lang=""></style>
