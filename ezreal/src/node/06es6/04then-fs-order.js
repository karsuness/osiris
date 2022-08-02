import thenFs from 'then-fs'

thenFs.readFile('./file/file1.txt', 'utf8').then((result) => {
    console.log(result)
    return thenFs.readFile('./file/file22.txt', 'utf8')
}).then((result) => {
    console.log(result)
    return thenFs.readFile('./file/file3.txt', 'utf8')
}).then((result) => {
    console.log(result)
}).catch((error) => {
    console.log(error.message)
})