const fs = require('fs')

fs.readFile('./file/成绩.txt', function (err, dataStr) {
    if (err) {
        return console.log('读取文件失败，失败信息是：' + err.message)
    }

    //成绩按照空格分割
    const arrOld = dataStr.toString().split(' ')

    //循环分割后的数组，对每个数据进行替换操作
    const arrNew = []

    arrOld.forEach(item => {
        arrNew.push(item.replace('=', '：'))
    })

    console.log("新的数组是：" + arrNew)

    //新数组中的每一项进行合并，并添加换行
    const newLine = arrNew.join('\n')

    fs.writeFile('./file/成绩-ok.txt', newLine, function (err) {
        if (err) {
            return console.log('写入文件失败，失败信息是：' + err.message)
        }
    })
})