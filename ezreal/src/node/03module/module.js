//自定义模块中默认module.exports={}

const age = 20

//向module.exports对象上挂载属性
module.exports.username = 'scott'

module.exports.method = () => {
    console.log("hello")
}

module.exports = {
    nickname: 'js',
    mm: function () {
        console.log("sss")
    }
}


