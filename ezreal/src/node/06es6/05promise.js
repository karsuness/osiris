import thenFs from 'then-fs'

const promiseArray = [
    thenFs.readFile('./file/file1.txt', 'utf8'),
    thenFs.readFile('./file/file2.txt', 'utf8'),
    thenFs.readFile('./file/file3.txt', 'utf8')
]

Promise.all(promiseArray).then((result) => {
    console.log(result)
})

Promise.race(promiseArray).then((result) => {
    console.log(result)
})