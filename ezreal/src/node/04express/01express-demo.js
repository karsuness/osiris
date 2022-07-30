//1.导入express
const express = require('express')

//2.创建web服务器
const app = express()


//监听get请求
app.get('/get', (request, response) => {
    response.send({name: 'wjx', age: 27, gender: '男'})
})

//监听post请求
app.post('/post', (request, response) => {
    response.send({name: 'zjl', age: 31, gender: '女'})
})

//查看请求参数
app.get('/param', (request, response) => {
    console.log(request.query)
    response.send('你好，你的请求参数是' + request.params)
})

//url中可以通过：参数名的形式匹配动态参数值
app.get('/param/:id', (request, response) => {
    console.log(request.params)
    // response.send('你好，你的请求参数是' + request.params)
    response.send(request.params)
})


//3.调用app.listen(端口号，启动成功后的回调函数)，启动服务器
app.listen(8888, () => {
    console.log('express server running')
})
