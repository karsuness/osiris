/**
 * 多个中间件之间共享同一份request、response 基于这样的特性，我们可以在上游的中间件中，统一为request、response对象添加自定义的属性和方法，供下游的中间件或路由进行使用
 * 错误级别的中间件必须注册在所有的路由之后
 * @type {e | (() => Express)}
 */

//1.导入express
const express = require('express')

//2.创建web服务器
const app = express()

const mw = function (request, response, next) {
    console.log('中间件函数')

    //中间件函数在自己的函数逻辑处理结束之后必须调用next函数，将流转关系转交给下一个中间件
    next()
}

//客户端发起的任何请求，到达服务器之后都会触发的中间件叫做全局生效的中间件。通过调用app.use(中间件函数)，即可定义一个全局生效的中间件
app.use(mw)

app.get('/get', (request, response) => {
    console.log('this is get')
    response.send('end.....')
})


//3.调用app.listen(端口号，启动成功后的回调函数)，启动服务器
app.listen(8888, () => {
    console.log('express server running')
})