package main

import (
	"bytes"
	"github.com/gin-gonic/gin"
	"io/ioutil"
	"net/http"
)

func main() {
	r := gin.Default()
	r.POST("/param", func(context *gin.Context) {
		bodyBytes, err := ioutil.ReadAll(context.Request.Body)
		//读取出的数据重新写入request中
		context.Request.Body = ioutil.NopCloser(bytes.NewBuffer(bodyBytes))
		firstName := context.PostForm("firstName")
		lastName := context.DefaultPostForm("lastName", "go")
		if err != nil {
			context.String(http.StatusBadRequest, err.Error())
			context.Abort()
		}
		context.String(http.StatusOK, "%s,%s", firstName, lastName)
	})
	r.Run(":9090")
}
