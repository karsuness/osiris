import mysql from 'mysql2'
import config from 'config'

const pool = mysql.createPool({
    host: config.get('mysql.host'),
    port: config.get('mysql.port'),
    user: config.get('mysql.user'),
    password: config.get('mysql.password'),
    database: config.get('mysql.database')
})

//默认导出一个支持promise api的pool

export default pool.promise()