const config = require('config')

let host = config.get('mysql.host')

console.log(host)