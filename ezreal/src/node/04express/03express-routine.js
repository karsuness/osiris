//1.导入express
const express = require('express')
const userRouter = require('./04router')


//2.创建web服务器
const app = express()

//app.use 函数作用就是注册全局中间件

//使用app.user()注册路由模块
app.use(userRouter)

//添加统一前缀
app.use('/api', userRouter)

//3.调用app.listen(端口号，启动成功后的回调函数)，启动服务器
app.listen(8888, () => {
    console.log('express server running')
})