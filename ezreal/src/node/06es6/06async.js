import thenFs from 'then-fs'

async function readFiles() {
    const r1 = await thenFs.readFile('./file/file1.txt', 'utf8')
    console.log(r1)

    const r2 = await thenFs.readFile('./file/file2.txt', 'utf8')
    console.log(r2)

    const r3 = await thenFs.readFile('./file/file3.txt', 'utf8')
    console.log(r3)
}

readFiles()