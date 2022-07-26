const http = require('http')

//创建web服务器实例
const server = http.createServer()

//为服务器实例绑定request事件，监听客户端请求
server.on('request', function (request, result) {
    //请求的url
    const url = request.url

    //请求方式
    const method = request.method

    const str = `your request url is ${url},method is ${method}`

    console.log("someone visit web server")
    console.log(str)

    //向客户端发送指定内容，并结束这次请求的处理过程
    result.setHeader('Content-Type', 'text/html;charset=utf8')
    result.end('请求结束')
})

//启动服务器
server.listen(8888, function () {
    console.log("server is running")
})