package _error

import (
	"errors"
	"fmt"
)

func MyDiv(a, b int) (result int, err error) {
	err = nil
	if b == 0 {
		err = errors.New("除数不能为0")
	} else {
		result = a / b
	}
	return
}

func Fun2(a, b int) {
	result, err := MyDiv(a, b)
	fmt.Printf("result is %d,err is %s", result, err)
}

func Fun1() {
	er := errors.New("this is my first go error")
	fmt.Println(er)

}
