//1.按需导入createApp函数
import {createApp} from 'vue'

//2.导入待渲染App.vue
import App from './App.vue'

import './index.css'

//3.调用createApp函数，创建spa应用实例
const app = createApp(App)

//4.调用mount函数把app组件渲染到指定的el区域中
app.mount('#app')
