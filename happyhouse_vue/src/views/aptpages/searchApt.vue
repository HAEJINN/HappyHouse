d
<!-- 시군구검색, 아파트이름(or동이름)검색 -->
<template>
  <div class="test">
    <div class="select_wrap">
      <input
        type="radio"
        name="selectType"
        id="sigungu"
        value="sigungu"
        v-model="ckType"
        @change="clear"
      />
      <label for="sigungu">시,군,구 검색</label>
      <input
        type="radio"
        name="selectType"
        id="aptname"
        value="aptname"
        v-model="ckType"
        @change="clear"
      />
      <label for="aptname">아파트 이름 검색</label>
      <input
        type="radio"
        name="selectType"
        id="dongname"
        value="dongname"
        v-model="ckType"
        @change="clear"
      />
      <label for="dongname">동 이름 검색</label>
    </div>
    <div class="search_wrap">
      <div v-if="ckType == 'sigungu'">
        <!-- <h3>시군구 검색</h3> -->
        <div class="selects">
          <select id="city" v-model="city" @change="loadGugun">
            <option value="" selected disabled hidden>--시--</option>
            <option v-for="(city, idx) in citys" :key="idx" :value="city">
              {{ city }}
            </option>
          </select>
          <select id="gugun" v-model="gugun" @change="loadDong">
            <option value="" selected disabled hidden>--군--</option>
            <option v-for="(gugun, idx) in guguns" :key="idx" :value="gugun">
              {{ gugun }}
            </option>
          </select>
          <select id="dong" v-model="dong" @change="loadResult">
            <option value="" selected disabled hidden>--구--</option>
            <option v-for="(dong, idx) in dongs" :key="idx" :value="dong">
              {{ dong }}
            </option>
          </select>
        </div>
        <p v-show="isShow">마커를 클릭하면 즐겨찾기에 추가됩니다</p>
      </div>
      <div v-if="ckType == 'aptname'" class="innerwrap">
        <!-- <h3>아파트 이름 검색</h3> -->
        <div class="inner">
          <input
            type="text"
            id="searchname"
            name="searchname"
            v-model="searchname"
            class="searchinput"
            @keyup.enter="searchAptName"
          />
          <button @click="searchAptName" class="searchbtn">검색</button>
        </div>
        <p v-show="isShow">마커를 클릭하면 즐겨찾기에 추가됩니다</p>
      </div>
      <div v-if="ckType == 'dongname'">
        <!-- <h3>동 이름 검색</h3> -->
        <div class="inner">
          <input
            type="text"
            id="searchname"
            name="searchname"
            v-model="searchname"
            class="searchinput"
            @keyup.enter="searchDongName"
          />
          <button @click="searchDongName" class="searchbtn">검색</button>
        </div>
        <p v-show="isShow">마커를 클릭하면 즐겨찾기에 추가됩니다</p>
      </div>
    </div>
    <result-comp></result-comp>
  </div>
</template>
<script>
import ResultComp from '@/views/aptpages/resultComp.vue';
import http from '@/util/http-common';
export default {
  name: 'searchApt',
  components: {
    ResultComp,
  },
  data: function () {
    return {
      ckType: '',
      citys: [],
      guguns: [],
      dongs: [],
      city: '',
      gugun: '',
      dong: '',
      searchname: '',
      isShow: false,
    };
  },
  methods: {
    clear() {
      this.searchname = '';
      this.isShow = false;
      this.city = '';
      this.gugun = '';
      this.dong = '';
    },
    searchAptName() {
      this.isShow = true;
      this.$store.dispatch('loadResultbyApt', this.searchname);
    },
    searchDongName() {
      this.isShow = true;
      this.$store.dispatch('loadResultbyDong', this.searchname);
    },
    loadGugun() {
      http
        .post('/base/gugun', { city: this.city })
        .then(({ data }) => {
          this.guguns = data;
        })
        .catch(() => {
          alert('구군 받아오기 실패');
        });
    },
    loadDong() {
      http
        .post('/base/dong', { city: this.city, gugun: this.gugun })
        .then(({ data }) => {
          this.dongs = data;
        })
        .catch(() => {
          alert('동 받아오기 실패');
        });
    },
    loadResult() {
      this.isShow = true;
      this.$store.dispatch('loadResult', this.dong);
    },
  },
  created() {
    this.$store.dispatch('clearMapData');
    http
      .get('/base/city')
      .then(({ data }) => {
        this.citys = data;
      })
      .catch(() => {
        alert('시 받아오기 실패');
      });
  },
};
</script>
<style scoped>
.select_wrap {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 2em 0 1em;
  font-size: 1.4em;
}

.select_wrap label {
  margin: 0 5px;
}

.search_wrap {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 2em;
}
.selects {
  display: flex;
}
.selects select {
  width: 8em;
  font-size: 1.2em;
  margin: 0 0.3em;
}
.searchinput {
  width: 10em;
  font-size: 1.2em;
}
.searchbtn {
  margin-left: 0.5em;
}
.innerwrap {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.inner {
  display: flex;
  justify-content: center;
}
p {
  margin-bottom: 0;
  font-size: 1.2em;
  color: grey;
  text-align: center;
}
</style>
