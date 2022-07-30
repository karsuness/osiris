const express = require('express')
const parser = require('body-parser');


const apiRouter = express.Router()

apiRouter.get('/get', (request, response) => {
    const query = request.query
    console.log('请求get接口，参数是' + query)
    response.send(success(query))
})

apiRouter.post('/post', (request, response) => {
    const body = request.data
    let data = parser.json(body)
    console.log('请求post接口，参数是' + data)
    response.send(success(data))
})

function success(data) {
    return {status: 200, code: 0, message: 'success', data: data}
}

module.exports = apiRouter