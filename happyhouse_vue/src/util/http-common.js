import axios from 'axios';

// axios 객체 생성
export default axios.create({
  // baseURL: 'http://localhost:9999/happyhouse',
  baseURL: 'http://172.16.101.99:9999/happyhouse',
  headers: {
    'Content-type': 'application/json',
  },
});