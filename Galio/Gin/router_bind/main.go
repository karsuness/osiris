package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
	"time"
)

type Person struct {
	Name     string    `form:"name"`
	Age      int       `form:"age"`
	BirthDay time.Time `form:"birthDay" time_format:"2006-01-02"`
}

func main() {
	r := gin.Default()
	r.GET("/bind", bindFunction)
	r.POST("/bind", bindFunction)
	r.Run(":9090")
}

func bindFunction(ctx *gin.Context) {
	var person Person
	if err := ctx.ShouldBind(&person); err != nil {
		ctx.String(http.StatusBadRequest, err.Error())
	}
	ctx.String(http.StatusOK, "%v", person)
}
