package _json

import (
	"encoding/json"
	"fmt"
)

type IT struct {
	Company string   `json:"company""` //二次编码
	Subject []string `json:"-"`        //不会输出json
	IsOk    bool     `json:",string"`  //转成string输出
	Price   float64  `json:"price"`
}

func Fun1() {

	s := IT{"suidifu", []string{"java", "c", "c++", "python", "go"}, true, 123.456}

	//编码成json格式
	//b, _ := json.Marshal(s)

	//格式化
	b, _ := json.MarshalIndent(s, "", " ")
	fmt.Println(string(b))
}

func Fun2() {
	m := make(map[string]interface{}, 4)
	m["Company"] = "suidifu"
	m["Subject"] = []string{"java", "c", "c++", "python", "go"}
	m["IsOk"] = true
	m["Price"] = 122.33

	//格式化
	b, _ := json.MarshalIndent(m, "", " ")
	fmt.Println(string(b))
}

func Fun3() {
	jsonStr := `{
 "company": "suidifu",
"Subject":["java","C++"],
 "IsOk": "true",
 "price": 123.456
}`
	var structS IT
	error := json.Unmarshal([]byte(jsonStr), &structS)
	if error == nil {
		fmt.Println(structS)
	} else {
		fmt.Println(error)
	}
}

func Fun4() {
	m := make(map[string]interface{}, 4)
	jsonStr := `{
 "company": "suidifu",
"Subject":["java","C++"],
 "IsOk": "true",
 "price": 123.456
}`

	error := json.Unmarshal([]byte(jsonStr), &m)
	if error == nil {
		fmt.Println(m)
	} else {
		fmt.Println(error)
	}

}
