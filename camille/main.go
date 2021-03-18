package main

import (
	"fmt"
)

//func init()  {
//	fmt.Println("this is main init")
//}

func main1() {
	//fun.Fun()
	fmt.Println("this is main")
	//point.Fun3()
	//array.Fun2()
	//random.Fun()
	//_error.Fun1()
	//_error.Fun2(1,0)
	//_string.Fun1()
	//_json.Fun4()
	//path:="/Users/wangjinxin/Desktop/demo.txt"
	//_file.Fun3(path)

	//使用go关键字创建一个协程，新建一个任务
	//go _goroutine.Fun1()
	//
	//for{
	//	fmt.Println("this is main thread")
	//	time.Sleep(time.Second)
	//}

	//func(){
	//	fmt.Println("A")
	//	_goroutine.Fun2()
	//	fmt.Println("B")
	//}()
	//
	//for{
	//
	//}
}

func fibonacci(ch chan<- int, quit <-chan bool) {
	x, y := 1, 1
	for {
		//监听channel数据流动
		select {
		case ch <- x:
			x, y = y, x+y
		case flag := <-quit:
			fmt.Println("flag = ", flag)
			return
		}
	}
}

func main2() {
	//数字通信
	ch := make(chan int)
	//程序是否结束
	quit := make(chan bool)

	//消费者，从channel中读取内容
	go func() {
		for i := 0; i < 8; i++ {
			num := <-ch
			fmt.Println(num)
		}

		//停止
		quit <- true
	}()

	fibonacci(ch, quit)
}

func main() {
}
