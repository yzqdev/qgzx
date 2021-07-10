import ElementPlus from 'element-plus'
import 'element-plus/lib/theme-chalk/index.css'
import {createApp} from 'vue'
import router from './router'
import axios from 'axios'
axios.defaults.baseURL='http://localhost:8400'
import App from './App.vue'
import '@/assets/less/common.less'
import store from "@/store";

const app = createApp(App)

app.config.globalProperties.$http=axios
app.use(ElementPlus)
app.use(router)
app.use(store)
app.mount('#app')
