package random

import (
	"fmt"
	"math/rand"
	"time"
)

func Fun() {
	//设置种子，只需要设置一次，种子设置相同出现的随机数也相同
	//使用当前系统时间
	rand.Seed(time.Now().UnixNano())

	fmt.Println("随机数是", rand.Int())
	fmt.Println("100以内的随机数是", rand.Intn(100))
}
