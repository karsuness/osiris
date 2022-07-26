const http = require('http')

//创建web服务器实例
const server = http.createServer()

//为服务器实例绑定request事件，监听客户端请求
server.on('request', function (request, result) {

    let url = request.url
    let content = '<h1>404 not find</h1>'

    if (url === '/' || url === '/index.html') {
        content = '<h1>首页</h1>'
    } else if (url === '/about.html') {
        content = '<h1>关于</h1>'
    }

    //向客户端发送指定内容，并结束这次请求的处理过程
    result.setHeader('Content-Type', 'text/html;charset=utf8')
    result.end(content)
})

//启动服务器
server.listen(8888, function () {
    console.log("server is running")
})