<template lang="">
  <div>
    <h1>{{ user.userid }}</h1>
    <h1>{{ user.username }}</h1>
    <h1>{{ user.email }}</h1>
    <h1>{{ user.phonenumber }}</h1>
    <h1>{{ user.gender }}</h1>
    <button @click="deleteuser(user.userid)">유저 삭제</button>
  </div>
</template>
<script>
import http from "@/util/http-common";

export default {
  name: "userlist",
  props: ["user"],
  methods: {
    async deleteuser(userid) {
      await http
        .delete(`/admin/user/${userid}`, {
          headers: {
            "access-token": window.localStorage.getItem("access-token"),
          },
        })
        .then(({ data }) => {
          if (data == "SUCCESS") {
            alert("유저 삭제성공");
          }
        })
        .catch(() => {
          alert("유저 삭제실패");
        });
      this.$router.go();
      //페이지 새로고침
    },
  },
};
</script>
<style lang=""></style>
