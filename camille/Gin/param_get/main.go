package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

func main() {
	r := gin.Default()
	r.GET("/param", func(context *gin.Context) {
		firstName := context.Query("firstName")
		lastName := context.DefaultQuery("lastName", "defaultName")
		context.String(http.StatusOK, "%s,%s", firstName, lastName)
	})
	r.Run(":9090") //设置启动端口号
}
