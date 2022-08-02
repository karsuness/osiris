import db from './db.js'

//获取所有用户信息
export async function getAllUser(request, response) {
    //db.query()返回值是promise的实例对象，使用async和await简化
    const [rows] = await db.query('select * from node_user')

    response.send({
        status: 200,
        code: 0,
        message: '请求成功',
        data: rows
    })
}