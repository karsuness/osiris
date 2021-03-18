package _goroutine

import (
	"fmt"
	"runtime"
	"time"
)

func Fun1() {
	for {
		fmt.Println("this is a new task")
		time.Sleep(time.Second)
	}
}

func Fun2() {
	defer fmt.Println("C")
	//return
	runtime.Goexit()
	fmt.Println("D")
}

func Fun3() {
	n := runtime.GOMAXPROCS(4)
	fmt.Println(n)
}

func Fun4() {
	//创建一个定时器，设置2s，2s后往通道中写入当前时间
	//time.NewTimer时间到了只会响应一次
	timer := time.NewTimer(2 * time.Second)

	//timer.C如果没有数据会阻塞
	t := <-timer.C
	fmt.Println("时间是", t)

}
