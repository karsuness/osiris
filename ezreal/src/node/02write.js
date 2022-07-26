const fs = require('fs')

fs.writeFile('./file/file2.txt','中文字符串',function (err){
    console.log(err)
})