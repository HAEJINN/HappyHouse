<template lang="">
  <div>
    <table>
      <tr>
        <th>아이디</th>
        <td>{{ user.userid }}</td>
      </tr>
      <tr>
        <th>이름</th>
        <td>{{ user.username }}</td>
      </tr>
      <tr>
        <th>이메일</th>
        <td>{{ user.email }}</td>
      </tr>
      <tr>
        <th>전화번호</th>
        <td>{{ user.phonenumber }}</td>
      </tr>
      <tr>
        <th>성별</th>
        <td>{{ user.gender }}</td>
      </tr>
    </table>
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
