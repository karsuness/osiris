const fs = require('fs')
const http = require('http')
const path = require('path')

//创建web服务器实例
const server = http.createServer()

//为服务器实例绑定request事件，监听客户端请求
server.on('request', (request, result) => {
    let url = request.url

    let fpath;

    if (url === '/') {
        fpath = path.join(__dirname, '/clock/index.html')
    } else {
        fpath = path.join(__dirname, '/clock', url)
    }

    fs.readFile(fpath, 'utf8', (err, data) => {
        if (err) {
            return result.end('404')
        }

        return result.end(data)
    })
})

//启动服务器
server.listen(8888, function () {
    console.log("server is running")
})



