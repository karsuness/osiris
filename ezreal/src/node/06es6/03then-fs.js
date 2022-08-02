import thenFs from 'then-fs'

/**
 * 无法按照顺序读取
 */
thenFs.readFile('./file/file1.txt', 'utf8').then((result) => {
    console.log(result)
})

thenFs.readFile('./file/file2.txt', 'utf8').then((result) => {
    console.log(result)
})

thenFs.readFile('./file/file3.txt', 'utf8').then((result) => {
    console.log(result)
})