const fs = require('fs')

fs.readFile('./file/file.txt', 'utf-8', function (err, data) {
    console.log(err)

    if (err) {
        return console.log('读取文件失败，错误信息是：' + err.message)
    }

    console.log('-----')
    console.log('读取文件成功，内容是：' + data)
})