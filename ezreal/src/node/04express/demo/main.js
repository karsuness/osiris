const express = require('express')
const apiRouter = require('./api-router')
const cors = require('cors')

const app = express()

//使用cors一定要在路由之前进行配置
app.use(cors())

app.use('/api', apiRouter)

app.listen(8888, () => {
    console.log('server is starting')
})