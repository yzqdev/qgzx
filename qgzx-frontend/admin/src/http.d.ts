/*
 * @Author: your name
 * @Date: 2020-04-15 16:27:47
 * @LastEditTime: 2020-04-15 16:38:14
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \examweb-vue\admin\http.d.ts
 */
import { AxiosInstance } from "axios";
declare module "vue/types/vue" {
  // 3. 声明为 Vue 补充的东西
  interface Vue {
    $http: AxiosInstance;
  }
}
