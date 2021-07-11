import { getApiUrl } from "@/utils/getApiUrl";

import axios from "axios";

axios.interceptors.request.use(
  (config) => {
    console.log("requestUrl==", config.url);

    // if (process.client) {
    //   if (localStorage.token) {
    //     config.headers.token = localStorage.token;
    //   }
    // }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);
// 添加响应拦截器

axios.interceptors.response.use(
  function (response) {
    // 对响应数据做点什么


    let { data } = response;
    console.log(`%c进入response`,`color:red;font-size:16px;background:transparent`)
      console.log('response=',data)
    return data;
  },
  function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
  }
);
axios.defaults.baseURL = getApiUrl();
export default axios;
