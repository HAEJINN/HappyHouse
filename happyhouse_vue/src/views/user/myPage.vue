<template>
  <div>
    <h1>내정보</h1>
    <table>
      <tr>
        <th>아이디</th>
        <td>{{ userid }}</td>
      </tr>
      <tr>
        <th>이름</th>
        <td>{{ username }}</td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td>{{ userpwd }}</td>
      </tr>
      <tr>
        <th>이메일</th>
        <td>{{ email }}</td>
      </tr>
      <tr>
        <th>전화번호</th>
        <td>{{ phonenumber }}</td>
      </tr>
      <tr>
        <th>성별</th>
        <td>{{ gender }}</td>
      </tr>
    </table>
    <div class="text-center">
      <router-link to="/happyhouse/main"><button>메인</button></router-link>
      <router-link :to="'/update?userid=' + userid"><button>수정</button></router-link>
      <router-link :to="'/delete?userid=' + userid"><button>삭제</button></router-link>
    </div>
  </div>
</template>
<script>
export default {
  name: 'mypage',
  props: {
    userid: { type: String },
    username: { type: String },
    userpwd: { type: String },
    email: { type: String },
    phonenumber: { type: String },
    gender: { type: String },
  },
};
</script>
