import thenFs from 'then-fs'


console.log('A')

async function readFiles() {

    console.log('B')
    const r1 = await thenFs.readFile('./file/file1.txt', 'utf8')

    const r2 = await thenFs.readFile('./file/file2.txt', 'utf8')

    const r3 = await thenFs.readFile('./file/file3.txt', 'utf8')

    console.log(r1)
    console.log(r2)
    console.log('C')
    console.log(r3)
}

readFiles()
console.log('D')