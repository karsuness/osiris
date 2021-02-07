package crawler

import (
	"fmt"
	"net/http"
	"os"
	"strconv"
)

func HttpGet(url string) (result string, err error) {
	resp, err1 := http.Get(url)
	if err1 != nil {
		err = err1
		return
	}

	//读取网络body内容
	buff := make([]byte, 4*1024)

	for {
		n, err := resp.Body.Read(buff)
		if n == 0 {
			//读取结束或出错
			fmt.Println("resp.Body.Read(buff)出错，err=", err)
			break
		}
		result += string(buff[:n])
	}
	return
}

func DoWork(start, end int) {
	fmt.Printf("即将爬取第%d页到%d页的内容", start, end)
	fileName := "/Users/wangjinxin/Desktop/file.html"
	for i := start; i <= end; i++ {
		url := "https://tieba.baidu.com/f?kw=lol&ie=utf-8&pn=" + strconv.Itoa((i-1)*50)
		fmt.Println("爬取的url是", url)
		//爬取操作
		result, err := HttpGet(url)
		if err != nil {
			fmt.Println("httpget发生异常，异常信息是", err)
			continue
		}

		//结果写入文件
		//fmt.Println("爬取到的内容是", result)
		file, err1 := os.OpenFile(fileName, os.O_WRONLY|os.O_APPEND, 0666)
		if err1 != nil {
			fmt.Println("打开文件失败，原因是", err1)
			fmt.Println("开始新建文件")
			file1, err2 := os.Create(fileName)
			if err2 != nil {
				fmt.Println("创建文件失败，失败原因是", err2)
			} else {
				file1.WriteString(result)
				file1.Close()
			}

		} else {
			file.WriteString(result)
			file.Close()
		}
	}
}

func Main() {
	var start, end int
	fmt.Println("请输入起始页")
	fmt.Scan(&start)
	fmt.Println("请输入结束页")
	fmt.Scan(&end)
	DoWork(start, end)
}
