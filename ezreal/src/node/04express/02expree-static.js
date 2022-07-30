//1.导入express
const express = require('express')

//2.创建web服务器
const app = express()

//express可以指定静态目录对外开放，但是要注意express在指定的目录中查找文件并对外提供资源的访问路径，因此存放静态文件的目录名不会出现在url中
app.use('/public', express.static('./public'))


//3.调用app.listen(端口号，启动成功后的回调函数)，启动服务器
app.listen(8888, () => {
    console.log('express server running')
})

