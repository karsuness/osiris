const path = require('path')
const fs = require("fs");

const newPath = path.join(__dirname,'/file/file.txt')

fs.readFile(newPath, 'utf-8', function (err, data) {
    console.log(err)

    const address = '/Users/wangjinxin/Desktop/file.txt'

    //获取文件地址
    const p = path.basename(address)

    //获取文件目录
    const d = path.dirname(address)

    //获取文件拓展名
    const e = path.extname(address)

    console.log(p)
    console.log(d)
    console.log(e)

    if (err) {
        return console.log('读取文件失败，错误信息是：' + err.message)
    }

    console.log('-----')
    console.log('读取文件成功，内容是：' + data)
})