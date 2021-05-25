<template lang="">
  <div>
    <adminuser-list v-for="(user, idx) in userlist" :key="idx" :user="user" />
  </div>
</template>
<script>
import http from "@/util/http-common";
import AdminuserList from "@/components/items/adminuserList.vue";

export default {
  data() {
    return {
      userlist: [],
    };
  },
  components: {
    AdminuserList,
  },
  created() {
    http
      .get("/admin/user", {
        headers: {
          "access-token": window.localStorage.getItem("access-token"),
        },
      })
      .then(({ data }) => {
        this.userlist = data;
      })
      .catch(() => {
        // alert('에러발생');
      });
  },
};
</script>
<style lang=""></style>
