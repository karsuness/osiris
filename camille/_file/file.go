package _file

import (
	"bufio"
	"fmt"
	"io"
	"os"
)

func Fun1(path string) {
	file, error := os.Create(path)
	if error != nil {
		fmt.Println("发生异常，错误信息是", error)
		return
	}

	defer file.Close()

	var buf string
	for i := 0; i < 10; i++ {
		buf = fmt.Sprintf("i is %d\n", i)
		file.WriteString(buf)
	}
}

func Fun2(path string) {
	file, error := os.Open(path)
	if error != nil {
		fmt.Println("打开文件发生异常，异常信息是", error)
		return
	}

	defer file.Close()

	buffer := make([]byte, 2048)

	n, err := file.Read(buffer)

	if err != nil && err != io.EOF {
		fmt.Println("读取文件发生异常，异常信息是", err)
		return
	}

	fmt.Println("读取到内容是", string(buffer[:n]))
}

func Fun3(path string) {
	file, error := os.Open(path)
	if error != nil {
		fmt.Println("打开文件发生异常，异常信息是", error)
		return
	}
	defer file.Close()

	r := bufio.NewReader(file)
	for {
		buf, err := r.ReadBytes('\n')
		if err != nil {
			if err == io.EOF {
				break
			}
			fmt.Println("error is ", err)
		}
		fmt.Println("read the line is ", string(buf))
	}

}
