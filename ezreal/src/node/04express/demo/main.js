const express = require('express')
const apiRouter = require('./api-router')
const cors = require('cors')

const app = express()

// 必须在配置 cors 中间件之前，配置 JSONP 的接口
app.get('/api/jsonp', (request, response) => {
    // 1. 得到函数的名称
    const funcName = request.query.callback
    // 2. 定义要发送到客户端的数据对象
    const data = {name: 'liusha', wife: 'baiwei'}
    // 3. 拼接出一个函数的调用
    const scriptStr = `${funcName}(${JSON.stringify(data)})`
    // 4. 把拼接的字符串，响应给客户端
    response.send(scriptStr)
})

//使用cors一定要在路由之前进行配置
app.use(cors())

app.use('/api', apiRouter)

app.listen(8888, () => {
    console.log('server is starting')
})