//导入express
var express = require('express')

//创建路由对象
var router = express.Router()

/**路由匹配的注意点
 1.按照定义的先后顺序进行匹配
 2.请求类型和请求的url同时匹配成功才会调用对应的处理函数
 **/

//获取接口路由
router.get('/user/list', function (request, response) {
    response.send('this is router get')
})

router.post('/user/list', function (request, response) {
    response.send('this is router get')
})

module.exports = router