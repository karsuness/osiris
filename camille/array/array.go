package array

import "fmt"

func Fun1() {
	var a [5]int
	for i := 0; i < len(a); i++ {
		a[i] = i + 1
	}

	fmt.Println("array a is ", a)

	for i, data := range a {
		fmt.Printf("a[%d] is %d \n", i, data)
	}
}

func Fun2() {
	a := [5]int{1, 2, 3, 4, 5}
	s1 := a[1:4:5]
	fmt.Println("s1 len is", len(s1))
	fmt.Println("s1 cap is", cap(s1))
	fmt.Println("s1 is", s1)
}
