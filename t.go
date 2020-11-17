package main

import (
  "fmt"
  "encoding/json"
)

type Test struct {
  A string `"json:a"`
  B int    `"json:b"`
}

func main() {
  var t = Test{A:"nisse", B:42}

  fmt.Println(t)
  j,_ := json.Marshal(t)
  fmt.Println(string(j))
}
