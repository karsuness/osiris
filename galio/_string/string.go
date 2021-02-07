package _string

import (
	"fmt"
	"strings"
)

func Fun1() {
	fmt.Println(strings.Contains("hello go", "go"))
	fmt.Println(strings.Contains("hello go", "java"))

	fmt.Println("----------------------------------")
	strs := []string{"go", "is", "a", "new", "language"}
	nstr := strings.Join(strs, " ")
	fmt.Println(nstr)
	fmt.Println("----------------------------------")
	fmt.Println(strings.Index("hello go", "go"))
	fmt.Println(strings.Index("hello go", "java"))
	fmt.Println("----------------------------------")
	nstr = strings.Repeat("go", 3)
	fmt.Println(nstr)
	fmt.Println("----------------------------------")
	str := "spring@cloud@boot@java"
	s1 := strings.Split(str, "@")
	fmt.Println(s1)
	fmt.Println("----------------------------------")
}
