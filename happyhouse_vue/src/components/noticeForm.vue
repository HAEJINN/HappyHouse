<template>
  <div>
    <div>
      <h1 v-if="type == 'update'">글 수정</h1>
      <h1 v-else>글 작성</h1>
      <div>
        <label for="title">제목</label>
        <input type="text" id="title" name="title" v-model="title" />
      </div>
      <div>
        <label for="userid">작성자</label>
        <input type="text" id="userid" name="userid" v-model="userid" disabled />
      </div>
      <div>
        <label for="content">내용</label>
        <textarea type="text" id="content" name="content" v-model="content" />
      </div>
      <button v-if="type == 'update'" @click="modify">수정</button>
      <button v-else @click="write">작성</button>
    </div>
  </div>
</template>
<script>
import http from '@/util/http-common';
import { mapState } from 'vuex';

export default {
  name: 'postForm',
  data() {
    return {
      title: '',
      userid: '',
      content: '',
      boardid: '',
    };
  },
  props: {
    type: { type: String },
  },
  computed: {
    ...mapState(['userInfo', 'isLogin']),
  },
  created() {
    this.userid = this.userInfo.userid;
    if (this.type === 'update') {
      this.title = this.$store.getters.notice.title;
      this.content = this.$store.getters.notice.content;
      this.boardid = this.$store.getters.notice.no;
    }
  },
  methods: {
    write() {
      http
        .post('/admin/board/', {
          title: this.title,
          userid: this.userid,
          content: this.content,
        })
        .then(({ data }) => {
          console.log(data);
          let msg = '글 작성시 문제가 발생했습니다.';
          if (data === 'SUCCESS') {
            msg = '글 작성이 완료되었습니다.';
          }
          alert(msg);
          this.$router.push('/happyhouse/noticeDetail');
        })
        .catch(() => {
          alert('글 작성시 에러가 발생했습니다.');
          this.$router.push('/happyhouse/noticeDetail');
        });
    },
    modify() {
      http
        .put('/admin/board/', {
          title: this.title,
          userid: this.userid,
          content: this.content,
          boardid: this.boardid,
        })
        .then(({ data }) => {
          console.log(data);
          let msg = '수정 처리시 문제가 발생했습니다.';
          if (data === 'SUCCESS') {
            msg = '수정이 완료되었습니다.';
          }
          alert(msg);
          this.$router.push('/happyhouse/noticeDetail');
        })
        .catch(() => {
          alert('수정 처리시 에러가 발생했습니다.');
          this.$router.push('/happyhouse/noticeDetail');
        });
    },
  },
};
</script>
