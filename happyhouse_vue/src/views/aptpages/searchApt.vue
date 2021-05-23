d
<!-- 시군구검색, 아파트이름(or동이름)검색 -->
<template>
  <div>
    <input
      type="radio"
      name="selectType"
      id="sigungu"
      value="sigungu"
      v-model="ckType"
    />
    <label for="sigungu">시,군,구 검색</label>
    <input
      type="radio"
      name="selectType"
      id="aptname"
      value="aptname"
      v-model="ckType"
    />
    <label for="aptname">아파트 이름 검색</label>
    <input
      type="radio"
      name="selectType"
      id="dongname"
      value="dongname"
      v-model="ckType"
    />
    <label for="dongname">동 이름 검색</label>
    <p>선택 : {{ ckType }}</p>
    <div v-if="ckType == 'sigungu'">
      <h3>시군구 검색</h3>
      <div>
        <select id="city" v-model="city" @change="loadGugun, removeList">
          <option v-for="(city, idx) in citys" :key="idx" :value="city">
            {{ city }}
          </option>
        </select>
        <select id="gugun" v-model="gugun" @change="loadDong">
          <option v-for="(gugun, idx) in guguns" :key="idx" :value="gugun">
            {{ gugun }}
          </option>
        </select>
        <select id="dong" v-model="dong" @change="loadResult">
          <option v-for="(dong, idx) in dongs" :key="idx" :value="dong">
            {{ dong }}
          </option>
        </select>
      </div>
    </div>
    <div v-if="ckType == 'aptname'">
      <h3>아파트 이름 검색</h3>
      <div>
        <input
          type="text"
          id="searchname"
          name="searchname"
          v-model="searchname"
        />
        <button @click="searchAptName">검색</button>
      </div>
    </div>
    <div v-if="ckType == 'dongname'">
      <h3>동 이름 검색</h3>
      <input
        type="text"
        id="searchname"
        name="searchname"
        v-model="searchname"
      />
      <button @click="searchDongName">검색</button>
    </div>
    <result-comp></result-comp>
  </div>
</template>
<script>
import ResultComp from "@/views/aptpages/resultComp.vue";
import http from "@/util/http-common";
export default {
  name: "searchApt",
  components: {
    ResultComp,
  },
  data: function () {
    return {
      ckType: "",
      citys: [],
      guguns: [],
      dongs: [],
      city: "",
      gugun: "",
      dong: "",
      searchname: "",
    };
  },
  methods: {
    searchAptName() {
      this.$store.dispatch("loadResultbyApt", this.searchname);
    },
    searchDongName() {
      this.$store.dispatch("loadResultbyDong", this.searchname);
    },
    loadGugun() {
      http
        .post("/base/gugun", { city: this.city })
        .then(({ data }) => {
          this.guguns = data;
        })
        .catch(() => {
          alert("구군 받아오기 실패");
        });
    },
    loadDong() {
      http
        .post("/base/dong", { city: this.city, gugun: this.gugun })
        .then(({ data }) => {
          this.dongs = data;
        })
        .catch(() => {
          alert("동 받아오기 실패");
        });
    },
    loadResult() {
      this.$store.dispatch("loadResult", this.dong);
    },
  },
  created() {
    http
      .get("/base/city")
      .then(({ data }) => {
        this.citys = data;
      })
      .catch(() => {
        alert("시 받아오기 실패");
      });
  },
};
</script>
