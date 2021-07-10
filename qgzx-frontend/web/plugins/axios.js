/*
 * @Author: your name
 * @Date: 2020-04-15 11:18:36
 * @LastEditTime: 2020-04-16 21:34:32
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \video-server\web\plugins\http.ts
 */
export default function({ $axios, redirect }, inject) {
  $axios.defaults.baseURL = "http://localhost:8400";
  $axios.onRequest(config => {
    console.log("Making request to " + config.url);
  });

  $axios.onError(error => {
    const code = parseInt(error.response && error.response.status);

    let info = new Map([
      [400, "请求错误(400)"],
      [403, "登录过期，请重新登录"],
      [404, `请求出错(404)`],
      [408, "请求超时(408)"],
      [500, "服务器错误(500)"],
      [502, "网络错误(502)"],
      [503, "服务不可用(503)"],
      [504, "网络超时(504)"],
      [505, "HTTP版本不受支持(505)"],
      ["default", `连接出错(${err.response.status})!`]
    ]);
    return info.get(code);
    // if (code === 400) {
    //   redirect('/400')
    // }
  });
  // Inject to context as $api
}
