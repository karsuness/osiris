//1.导入MySQL模块
const mysql = require('mysql')
const {ER_DUPLICATED_VALUE_IN_TYPE} = require("mysql/lib/protocol/constants/errors");

//建立与mysql数据库的连接
const db = mysql.createPool({
    host: '127.0.0.1',
    user: 'root',
    password: '123456',
    database: 'osiris'
})

//查询
db.query('select * from node_user where id < 10 ', (error, result) => {
    if (error) {
        //查询出错
        return console.log("错误信息是：" + error.message)
    }

    //查询成功
    console.log(result)
})

/**
 * 1.定义对象
 * 2.写新增SQL
 * @type {{sex: number, mobile: string, email: string, username: string}}
 */
// var user = {user_name: '夏草', email: 'xiacao@wacai.com', sex: 1, mobile: '18855466306'}
//
// let insertSql = 'INSERT INTO node_user SET ?'
//
// db.query(insertSql, user, (error, result) => {
//     if (error) {
//         //出错
//         return console.log("错误信息是：" + error.message)
//     }
//
//     //查询结果
//     if (result.affectedRows === 1) {
//         console.log("insert success")
//     }
// })

/**
 * 更新
 */
user = {id: 4, email: 'xiacao@wacai.com', sex: 1, mobile: '18855466991'}
let updateSql = 'UPDATE node_user SET ? WHERE id = ?'
db.query(updateSql, [user, user.id], (error, result) => {
    if (error) {
        //出错
        return console.log("错误信息是：" + error.message)
    }

    //查询结果
    if (result.affectedRows === 1) {
        console.log("update success")
    }
})



