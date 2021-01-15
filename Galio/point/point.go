package point

import "fmt"

func Fun1() {
	var a int = 10
	var b *int = &a
	*b = 666
	fmt.Println(" a is ", a)
	fmt.Println("a point is ", &a)
	fmt.Println(" b is ", b)
	fmt.Println("b point is ", &b)
}

func Fun2() {
	var p *int
	p = new(int)
	*p = 100
	a := *p
	fmt.Println("a is ", a)
	fmt.Println("p is ", p)
	fmt.Println("a point is ", &a)
}

func Fun3() {
	a, b := 10, 20
	c, d := 10, 20
	fmt.Println("before swap a,b is ", a, b)
	swap1(a, b)
	fmt.Println("after swap a,b is ", a, b)
	fmt.Println("before swap c,d is ", c, d)
	swap2(&c, &d)
	fmt.Println("after swap c,d is ", c, d)
}

func swap1(a, b int) {
	a, b = b, a
	fmt.Println("while swap a,b is ", a, b)
}

func swap2(a, b *int) {
	*a, *b = *b, *a
	fmt.Println("while swap a,b is ", *a, *b)
}
